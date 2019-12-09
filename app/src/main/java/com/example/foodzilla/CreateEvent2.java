package com.example.foodzilla;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateEvent2 extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;

    TextView textViewhosteventcevent, textVieweventnamecevent, textVieweventdatecevent, textVieweventtimecevent, textVieweventlocationcevent, textVieweventcapacitycevent, textVieweventinfocevent;
    EditText editTexteventnamecevent, editTexteventdatecevent, editTexteventtimecevent, editTexteventlocationcevent, editTexteventcapacitycevent, editTexteventinfocevent;
    Button buttonSubmiteventcevent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event2);

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
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.cornermenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.itemSpottingMap) {
            Intent spottingmapIntent = new Intent(this, SpottingMap.class);
            startActivity(spottingmapIntent);
        } else if (item.getItemId() == R.id.itemEvents) {
            Intent eventsIntent = new Intent(this, MyEvents.class);
            startActivity(eventsIntent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Events");

        if(buttonSubmiteventcevent == view) {
            String enteredName = editTexteventnamecevent.getText().toString();
            String enteredDate = editTexteventdatecevent.getText().toString();
            String enteredTime = editTexteventtimecevent.getText().toString();
            String enteredLocation = editTexteventlocationcevent.getText().toString();
            String enteredInfo = editTexteventinfocevent.getText().toString();
            String enteredCapacity = editTexteventcapacitycevent.getText().toString();

            EventClass myEvent = new EventClass(enteredName, "Signed up users TBA", "Event full TBA", enteredCapacity, enteredLocation, "Food served TBA", enteredDate, "End date and time TBA", enteredInfo, "Status TBA");
            myRef.push().setValue(myEvent);
        }

    }
}//t

