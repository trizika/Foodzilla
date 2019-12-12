package com.example.foodzilla;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.CameraX;
import androidx.camera.core.Preview;
import androidx.camera.core.PreviewConfig;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class ReportSpotting extends AppCompatActivity implements View.OnClickListener {
    EditText editTextLocationDetailsReportSpotting;

    Button buttonSubmitFoodReportSpotting;

    TextView textViewReportFoodSpotting;

    TextureView textureViewReportSpotting;

    private static final int MY_PERMISSIONS_REQUEST_CAMERA = 10;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_spoting); //test

        editTextLocationDetailsReportSpotting = findViewById(R.id.editTextLocationDetailsReportSpotting);
        buttonSubmitFoodReportSpotting = findViewById(R.id.buttonSubmitFoodReportSpotting);
        textViewReportFoodSpotting = findViewById(R.id.textViewReportFoodSpotting);
        textureViewReportSpotting = findViewById(R.id.textureViewReportSpotting);

        buttonSubmitFoodReportSpotting.setOnClickListener(this);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.cornermenu, menu);
        if (ContextCompat.checkSelfPermission(ReportSpotting.this,
                Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(ReportSpotting.this,
                    Manifest.permission.CAMERA)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(ReportSpotting.this,
                        new String[]{Manifest.permission.CAMERA},
                        MY_PERMISSIONS_REQUEST_CAMERA);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            // Permission has already been granted
            startCamera();
        }

        return super.onCreateOptionsMenu(menu);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.itemSpottingMap) {
            Intent spottingmapIntent = new Intent(this, SpottingMap.class);
            startActivity(spottingmapIntent);
        } else if (item.getItemId() == R.id.itemEvents) {
            Intent eventsIntent = new Intent(this, MyEvents.class);
            startActivity(eventsIntent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

        //Takes a snapshot of the current camera and puts it into a bitmap
        Bitmap pictureOfFood = textureViewReportSpotting.getBitmap();

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        final DatabaseReference myref = database.getReference("Spottings");
        Toast.makeText(this, myref.toString(), Toast.LENGTH_SHORT).show();

       FoodSpottingsClass spotting1 = new FoodSpottingsClass(
               editTextLocationDetailsReportSpotting.getText().toString(),
               pictureOfFood);

        Toast.makeText(this, spotting1.toString(), Toast.LENGTH_SHORT).show();
        myref.push().setValue(spotting1);
        //^stored code of bitmap


        //Intent intent1 = new Intent(ReportSpotting.this, SpottingMap.class);

        //startActivity(intent1);
    }
    public void startCamera(){
        PreviewConfig config = new PreviewConfig.Builder().build();
        Preview preview = new Preview(config);

        preview.setOnPreviewOutputUpdateListener(
                new Preview.OnPreviewOutputUpdateListener() {
                    @Override
                    public void onUpdated(Preview.PreviewOutput previewOutput) {

                        textureViewReportSpotting.setSurfaceTexture(previewOutput.getSurfaceTexture());
                    };
                });

        CameraX.bindToLifecycle((LifecycleOwner) this, preview);

    }
}
