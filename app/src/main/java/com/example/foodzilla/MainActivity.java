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

    private FirebaseAuth mAuth;

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

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View view) {

        if (view == buttonRegistermain) {
            makeNewUsers(editTextemailmain.getText().toString(), editTextpasswordmain.getText().toString());
        }else if (view == buttonLoginmain) {
            loginUser(editTextemailmain.getText().toString(),editTextpasswordmain.getText().toString());
        }
    }

    public void makeNewUsers(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //Display success message
                            Toast.makeText(MainActivity.this, "User registration successful", Toast.LENGTH_SHORT).show();
                        } else {
                            //Sign-in fails
                            Toast.makeText(MainActivity.this, "User registration failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void loginUser(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //Sign in
                            Intent loginIntent = new Intent(MainActivity.this, MyEvents.class);
                            startActivity(loginIntent);
                        } else {
                            // If sign in fails, display a message to the user
                            Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}