package com.example.foodzilla;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MyEvents extends AppCompatActivity {


    button buttonNOTHINGMyEvents, button buttonSwitchAvailableEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_events);

        buttonNOTHINGMyEvents = findViewById(R.id.buttonMyEventsCr);

    }
}
