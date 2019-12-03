package com.example.foodzilla;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MyEvents extends AppCompatActivity implements View.OnClickListener {


    Button buttonNOTHINGme, buttonSwitchMenuAv, buttonEvent1me, buttonEvent2me, buttonEvent3me;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_events);

        buttonNOTHINGme = findViewById(R.id.buttonMyEventsCr);
        buttonSwitchMenuAv = findViewById(R.id.buttonAvailableEventsCr);
        buttonEvent1me = findViewById(R.id.button1);
        buttonEvent2me = findViewById(R.id.button2);
        buttonEvent3me = findViewById(R.id.button3);
    }
    public void onClick(View view) {
        
    }


    }
