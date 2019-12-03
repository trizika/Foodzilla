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


    Button buttonNOTHINGme, buttonSwitchMenuAvme, buttonEvent1me, buttonEvent2me, buttonEvent3me;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_events);

        buttonNOTHINGme = findViewById(R.id.buttonMyEventsCr);
        buttonSwitchMenuAvme = findViewById(R.id.buttonAvailableEventsCr);
        buttonEvent1me = findViewById(R.id.button1);
        buttonEvent2me = findViewById(R.id.button2);
        buttonEvent3me = findViewById(R.id.button3);
    }

    public void onClick(View view) {
        if (view == buttonEvent1me || view == buttonEvent2me || view == buttonEvent3me) {
            Intent intent = new Intent(this, EventDetails.class);
            startActivity(intent);
        }
        else if (view == buttonSwitchMenuAvme) {
            Intent intent = new Intent(this, AvailableEvents.class);
            startActivity(intent);
        }
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
