package com.example.foodzilla;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

TextView textViewfoodzillamain;
EditText editTextemailmain, editTextpasswordmain;
Button buttonLoginmain, buttonRegistermain;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     textViewfoodzillamain = findViewById(R.id.textVieweventdateedetails);
     editTextemailmain = findViewById(R.id.editTextemailmain);
     editTextpasswordmain = findViewById(R.id.editTextpasswordmain);
     buttonLoginmain = findViewById(R.id.buttonLoginmain);
     buttonRegistermain = findViewById(R.id.buttonRegistermain);

     buttonRegistermain.setOnClickListener(this);
     buttonLoginmain.setOnClickListener(this);





    }

    @Override
    public void onClick(View view) {
        
    }
}
