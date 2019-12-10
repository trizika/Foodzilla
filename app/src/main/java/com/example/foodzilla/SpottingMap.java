package com.example.foodzilla;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class SpottingMap extends AppCompatActivity implements View.OnClickListener {

    Button gtfs1, gtfs2, gtfs3, addFoodSpotting;
    TextView fs1, fs2, fs3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spotting_map);

        addFoodSpotting = findViewById(R.id.buttonSubmitsmap);

        gtfs1 = findViewById(R.id.buttonGTFS1);
        gtfs2 = findViewById(R.id.buttonGTFS2);
        gtfs3 = findViewById(R.id.buttonGTFS3);

        fs1 = findViewById(R.id.textViewFS1);
        fs2 = findViewById(R.id.textViewFS2);
        fs3 = findViewById(R.id.textViewFS3);

        addFoodSpotting.setOnClickListener(this);
        gtfs1.setOnClickListener(this);
        gtfs2.setOnClickListener(this);
        gtfs3.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.cornermenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.itemSpottingMap) {
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

        if (view == addFoodSpotting) {

            Intent addspottingintent = new Intent(SpottingMap.this, ReportSpotting.class);

            startActivity(addspottingintent);

        }
    }
}
