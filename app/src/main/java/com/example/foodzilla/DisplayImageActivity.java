package com.example.foodzilla;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;
import java.net.URI;

public class DisplayImageActivity extends AppCompatActivity {
    ImageView imageViewPictureDisplayImage;
    private StorageReference mStorageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_image);
        imageViewPictureDisplayImage = findViewById(R.id.imageViewPictureDisplayImage);
        mStorageRef = FirebaseStorage.getInstance().getReference();
        try {
            downloadAndSetImage();

        } catch (IOException exc) {
        }
    }

    private void downloadAndSetImage() throws IOException {

        StorageReference riversRef = mStorageRef.child("images/rivers.jpg");
        File localFile = File.createTempFile("images", "jpg");
        riversRef.getFile(localFile)
                .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                        // Successfully downloaded data to local file
                        // ...
                        try {
                            Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), Uri.fromFile(localFile));
                            imageViewPictureDisplayImage.setImageBitmap(bitmap);
                        } catch (IOException exc) {

                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {


            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle failed download
                // ...
            }
        });

    }




}
