package com.example.foodzilla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Spottings extends AppCompatActivity implements View.OnClickListener {

    EditText editTextLocationDetailsReportSpotting;

    Button buttonSubmitFoodReportSpotting;

    ImageView imageViewSpottingPicReportSpotting;

    TextView textViewReportFoodSpotting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spottings);

        editTextLocationDetailsReportSpotting = findViewById(R.id.editTextLocationDetailsReportSpotting);
        buttonSubmitFoodReportSpotting = findViewById(R.id.buttonSubmitFoodReportSpotting);
        imageViewSpottingPicReportSpotting = findViewById(R.id.imageViewSpottingPicReportSpotting);
        textViewReportFoodSpotting = findViewById(R.id.textViewReportFoodSpotting);

        buttonSubmitFoodReportSpotting.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String spottingpic = imageViewSpottingPicReportSpotting
        // how do i getImage? instead of GetText
        String spottinglocation = editTextLocationDetailsReportSpotting.getText().toString();

        if (view == buttonSubmitFoodReportSpotting) {

            // submit that food spotting to the spotting database

            Intent landingintent = new Intent (SpottingsActivity.this, SpottingMap.class);
            startActivity(landingintent);
        }

    }
}
