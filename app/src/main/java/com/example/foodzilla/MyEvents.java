package com.example.foodzilla;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MyEvents extends AppCompatActivity implements View.OnClickListener {


    Button buttonNOTHINGme, buttonSwitchMenuAvme, buttonEvent1me, buttonGoToHostEvent,buttonEvent2me, buttonEvent3me, buttonRSVPForEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_events);

        buttonNOTHINGme = findViewById(R.id.buttonMyEventsCr);
        buttonSwitchMenuAvme = findViewById(R.id.buttonAvailableEventsCr);
        buttonEvent1me = findViewById(R.id.button1);
        buttonGoToHostEvent = findViewById(R.id.buttonGoToHostEvent);
        buttonEvent3me = findViewById(R.id.button3);
        buttonRSVPForEvent = findViewById(R.id.button5);
        buttonEvent2me = findViewById(R.id.button2);

        buttonNOTHINGme.setOnClickListener(this);
        buttonSwitchMenuAvme.setOnClickListener(this);
        buttonEvent1me.setOnClickListener(this);
        buttonEvent2me.setOnClickListener(this);
        buttonEvent3me.setOnClickListener(this);
        buttonGoToHostEvent.setOnClickListener(this);
        buttonRSVPForEvent.setOnClickListener(this);
    }

    public void onClick(View view) {

       if (view == buttonNOTHINGme) {
           Intent myEventsIntent = new Intent(this, MyEvents.class);
           startActivity(myEventsIntent);
       } else if (view == buttonSwitchMenuAvme) {
           Intent availableEventsIntent = new Intent(this, AvailableEvents.class);
           startActivity(availableEventsIntent);
       } else if (view == buttonGoToHostEvent) {
           //Intent goToHostEventIntent = new Intent() -> Do we have an activity where user puts in the info for the events
           //startActivity(goToHostEventIntent);
       } else if (view == buttonRSVPForEvent) {
           Intent goToRSVPForEvent = new Intent(this, AvailableEvents.class);
           startActivity(goToRSVPForEvent); //We want user to see and choose from the available events, right?
       }


       // I put this code into a comment - What should happen here? How can someone press three buttons at a time?!
       // if (view == buttonEvent1me || view == buttonEvent2me || view == buttonEvent3me) {
       //     Intent intent = new Intent(this, EventDetails.class);
       //     startActivity(intent);
       // }
       // else if (view == buttonSwitchMenuAvme) {
       //     Intent intent = new Intent(this, AvailableEvents.class);
       //     startActivity(intent);
       //}
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
