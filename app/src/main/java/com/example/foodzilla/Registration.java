package com.example.foodzilla;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registration extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;

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

        mAuth = FirebaseAuth.getInstance();




    }

    @Override
    public void onClick(final View view) {

        String email = editTextemailreg.getText().toString();
        String password = editTextpassreg.getText().toString();


                        if (view == submitbuttonreg) {
                            mAuth.createUserWithEmailAndPassword(email, password)
                                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                        @Override
                                        public void onComplete(@NonNull Task<AuthResult> task) {
                                            if (task.isSuccessful()) {
                                                Toast.makeText(Registration.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                                Intent mainIntent = new Intent(Registration.this, SpottingMap.class);
                                                startActivity(mainIntent);
                                                FirebaseDatabase database =  FirebaseDatabase.getInstance();

                                                final DatabaseReference myref = database.getReference("Users");



                                                Person person1 = new Person(editTextfnamereg.getText().toString(), editTextlnamereg.getText().toString(), editTextemailreg.getText().toString());

                                                myref.push().setValue(person1);


                                                Intent intent1 = new Intent(Registration.this, SpottingMap.class);

                                                startActivity(intent1);
                                            } else {
                                                Toast.makeText(Registration.this, "Registration Failed", Toast.LENGTH_SHORT).show();

                                            }
                                        }
                                    });

                        } else {
                            Toast.makeText(Registration.this, "Registration Failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }







        }


