package com.example.foodzilla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ReportSpotting extends AppCompatActivity implements View.OnClickListener {
    EditText editTextLocationDetailsReportSpotting;

    Button buttonSubmitFoodReportSpotting;

    ImageView imageViewSpottingPicReportSpotting;

    TextView textViewReportFoodSpotting;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_spoting);

        editTextLocationDetailsReportSpotting = findViewById(R.id.editTextLocationDetailsReportSpotting);
        buttonSubmitFoodReportSpotting = findViewById(R.id.buttonSubmitFoodReportSpotting);
        imageViewSpottingPicReportSpotting = findViewById(R.id.imageViewSpottingPicReportSpotting);
        textViewReportFoodSpotting = findViewById(R.id.textViewReportFoodSpotting);

        buttonSubmitFoodReportSpotting.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        final DatabaseReference myref = database.getReference("Spottings");


        FoodSpottingsClass spotting1 = new FoodSpottingsClass(editTextLocationDetailsReportSpotting.getText().toString());
                //imageViewSpottingPicReportSpotting.set.toString());

        myref.push().setValue(spotting1);


        Intent intent1 = new Intent(ReportSpotting.this, SpottingMap.class);

        startActivity(intent1);
    }
}
