package com.example.foodzilla;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MyEvents extends AppCompatActivity {


    Button buttonNOTHINGMyEvents, buttonSwitchMenuAv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_events);

        buttonNOTHINGMyEvents = findViewById(R.id.buttonMyEventsCr);
        buttonSwitchMenuAv = findViewById(R.id.buttonAvailableEventsCr);


    }
}
