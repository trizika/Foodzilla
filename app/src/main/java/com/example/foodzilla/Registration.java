package com.example.foodzilla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Registration extends AppCompatActivity implements View.OnClickListener {



    EditText editTextfnamereg, editTextlnamereg, editTextemailreg, editTextpassreg;
    Button submitbuttonreg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        editTextfnamereg = findViewById(R.id.editTextfnamereg);
        editTextlnamereg = findViewById(R.id.editTextlnamereg);
        editTextemailreg = findViewById(R.id.editTextemailreg);
        editTextpassreg = findViewById(R.id.editTextpassreg);

        submitbuttonreg.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if (view == submitbuttonreg) {


            Intent intent1 = new Intent(this, SpottingMap.class);

            startActivity(intent1);


        }


    }
}
