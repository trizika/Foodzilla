package com.example.foodzilla;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PreferencesActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textViewLocation, textViewNotifications;
    Button buttonLocationYes,buttonLocationNo, buttonNotificationYes, buttonNotificationNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);
        textViewLocation = findViewById(R.id.textViewLocation);
        textViewNotifications = findViewById(R.id.textViewNotifications);
        buttonLocationNo = findViewById(R.id.buttonLocationNo);
        buttonLocationYes = findViewById(R.id.buttonLocationYes);
        buttonNotificationNo = findViewById(R.id.buttonNotificationNo);
        buttonNotificationYes = findViewById(R.id.buttonNotificationYes);

        buttonNotificationNo.setOnClickListener(this);
        buttonNotificationYes.setOnClickListener(this);
        buttonLocationYes.setOnClickListener(this);
        buttonLocationNo.setOnClickListener(this);

    }
//..
    @Override
    public void onClick(View view) {

        if (view = )

            else if (view = )

    }
}
