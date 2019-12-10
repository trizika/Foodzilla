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

/**
public class RsvpdEvents extends AppCompatActivity implements View.OnClickListener {

    TextView textViewrsvpdattendingrevents, textVieweventnamerevents, textVieweventdaterevents, textVieweventtimerevents, textVieweventlocationrevents, textVieweventinforevents;
    Button buttonCancelrsvprevents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rsvpd_events);

        textViewrsvpdattendingrevents= findViewById(R.id.textViewrsvpdattendingrevents);
        textVieweventnamerevents = findViewById(R.id.textVieweventnamerevents);
        textVieweventdaterevents = findViewById(R.id.textVieweventdaterevents);
        textVieweventtimerevents = findViewById(R.id.textVieweventtimerevents);
        textVieweventlocationrevents = findViewById(R.id.textVieweventlocationrevents);
        textVieweventinforevents = findViewById(R.id.textVieweventinforevents);
        buttonCancelrsvprevents = findViewById(R.id.buttonCancelrsvprevents);

        buttonCancelrsvprevents.setOnClickListener(this);


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
}
 **/
