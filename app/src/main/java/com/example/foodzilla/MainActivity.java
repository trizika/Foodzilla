package com.example.foodzilla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

TextView textViewfoodzillamain;
EditText editTextemailmain, editTextpasswordmain;
Button buttonLoginmain, buttonRegistermain;

    private FirebaseAuth mAuth;

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

 mAuth = FirebaseAuth.getInstance();



    }

    @Override
    public void onClick(View view) {

      String email = editTextemailmain.getText().toString();
      String password = editTextpasswordmain.getText().toString();

      if (view == buttonRegistermain){
          mAuth.createUserWithEmailAndPassword(email, password)
                  .addOnCompleteListener(this, (task) --> {
          if (task.isSuccessful()) {
              Toast.makeText(MainActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
              Intent mainIntent = new Intent(MainActivity.this, SpottingMap.class);
          } else {
              Toast.makeText(MainActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
          }

          Intent landingIntent = new Intent(this, SpottingMap.class);
          startActivity(landingIntent);


          else if (view == buttonLoginmain) {
              mAuth.signInWithEmailAndPassword(email, password)
                      .addOnCompleteListener(this, "Login Unsuccessful", Toast.LENGTH_SHORT).show();
          }
          });

          Intent landingintent = new Intent(this, SpottingMap.class);
          startActivity(landingintent);

    }
}