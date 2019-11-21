package com.example.foodzilla;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateEvent extends AppCompatActivity implements View.OnClickListener {

    TextView textViewhosteventcevent, textVieweventnamecevent, textVieweventdatecevent, textVieweventtimecevent, textVieweventlocationcevent, textVieweventcapacitycevent, textVieweventinfocevent;
    EditText editTexteventnamecevent, editTexteventdatecevent, editTexteventtimecevent, editTexteventlocationcevent, editTexteventcapacitycevent, editTexteventinfocevent;
    Button buttonSubmiteventcevent;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);


        textViewhosteventcevent = findViewById(R.id.textViewhosteventcevent);
        textVieweventnamecevent = findViewById(R.id.textVieweventnamecevent);
        textVieweventcapacitycevent = findViewById(R.id.textVieweventcapacitycevent);
        textVieweventinfocevent = findViewById(R.id.textVieweventinfocevent);
        textVieweventdatecevent = findViewById(R.id.textVieweventdatecevent);
        textVieweventtimecevent = findViewById(R.id.textVieweventtimecevent);
        textVieweventlocationcevent = findViewById(R.id.textVieweventlocationcevent);

        editTexteventdatecevent = findViewById(R.id.editTexteventdatecevent);
        editTexteventnamecevent = findViewById(R.id.editTexteventnamecevent);
        editTexteventtimecevent = findViewById(R.id.editTexteventtimecevent);
        editTexteventlocationcevent = findViewById(R.id.editTexteventlocationcevent);
        editTexteventcapacitycevent = findViewById(R.id.editTexteventcapacitycevent);
        editTexteventinfocevent = findViewById(R.id.editTexteventinfocevent);

        buttonSubmiteventcevent = findViewById(R.id.buttonSubmiteventcevent);


        buttonSubmiteventcevent.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();


    }

    @Override
    public void onClick(View view) {

        String eventdate = editTexteventdatecevent.getText().toString();
        String eventname = editTexteventnamecevent.getText().toString();
        String eventtime = editTexteventtimecevent.getText().toString();
        String eventlocation = editTexteventlocationcevent.getText().toString();
        String eventcapacity = editTexteventcapacitycevent.getText().toString();
        String eventinfo = editTexteventinfocevent.getText().toString();


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Events");


        if (view == buttonSubmiteventcevent) {

            EventClass newEvent = new EventClass()





        }
    }
}