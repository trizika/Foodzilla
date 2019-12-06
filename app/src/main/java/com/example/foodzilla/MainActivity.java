package com.example.foodzilla;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
//test
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

        if (view == buttonRegistermain) {
            Intent landingintent = new Intent(MainActivity.this, Registration.class);
            startActivity(landingintent);

        } else if (view == buttonLoginmain) {
            Intent landingintent = new Intent(MainActivity.this, ReportSpotting.class);
            startActivity(landingintent);

            /**

            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Intent landingintent = new Intent(MainActivity.this, SpottingMap.class);
                                startActivity(landingintent);
                                Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();

                            } else {
                                Toast.makeText(MainActivity.this, "LogIn Failed", Toast.LENGTH_SHORT).show();

                            }

                        }
                    });**/

        }
    }
}