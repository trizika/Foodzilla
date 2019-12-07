package com.example.foodzilla;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;

public class ReportSpotting2 extends AppCompatActivity implements View.OnClickListener {
    private Button buttonSelectImage, buttonUploadImage, buttonSubmitLocationReportSpotting2;
    EditText editTextLocationReportSpotting2;
    private ImageView imageViewPicture;
    private int PICK_IMAGE_REQUEST = 1;
    private StorageReference mStorageRef;
    private Uri selectedImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mStorageRef = FirebaseStorage.getInstance().getReference();
        setContentView(R.layout.activity_report_spotting2);
        buttonSelectImage = findViewById(R.id.buttonSelectImage);
        buttonUploadImage = findViewById(R.id.buttonUploadImage);
        buttonSubmitLocationReportSpotting2 = findViewById(R.id.buttonSubmitFoodReportSpotting);
        editTextLocationReportSpotting2 = findViewById(R.id.editTextLocationReportSpotting2);
        imageViewPicture = findViewById(R.id.imageViewPicture);
        buttonSelectImage.setOnClickListener(this);
        buttonUploadImage.setOnClickListener(this);
        buttonSubmitLocationReportSpotting2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == buttonSelectImage){
            selectImages();
        }

        else if (view == buttonUploadImage){
            uploadFile();
        }

    }
    private void selectImages(){
        Intent intent = new Intent();
        intent.setType("image");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {

            Uri uri = data.getData();
            selectedImageUri = uri;

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                // Log.d(TAG, String.valueOf(bitmap));

                ImageView imageViewPicture = (ImageView) findViewById(R.id.imageViewPicture);
                imageViewPicture.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void uploadFile(){
        StorageReference storageRef;
        StorageReference riversRef = mStorageRef.child("images/rivers.jpg");

        riversRef.putFile(selectedImageUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        // Get a URL to the uploaded content
                        Toast.makeText(ReportSpotting2.this, "Upload Successful", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle unsuccessful uploads
                    }
                });


    }



}



