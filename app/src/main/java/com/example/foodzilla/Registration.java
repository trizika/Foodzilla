package com.example.foodzilla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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

        FirebaseDatabase database =  FirebaseDatabase.getInstance();

        final DatabaseReference myref = database.getReference("Users");


        if (view == submitbuttonreg) {


            Person person1 = new Person(editTextfnamereg.getText().toString(), editTextlnamereg.getText().toString(), editTextemailreg.getText().toString());

            myref.push().setValue(person1);


            Intent intent1 = new Intent(this, SpottingMap.class);

            startActivity(intent1);


        }


    }
}
