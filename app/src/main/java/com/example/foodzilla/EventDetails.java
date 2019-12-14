package com.example.foodzilla;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
//.
public class EventDetails extends AppCompatActivity {

    TextView textVieweventdetailsedetails,textVieweventnameedetails, textVieweventdateedetails,textVieweventtimeedetails, textVieweventlocationedetails, textVieweventinfoedetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        textVieweventdateedetails = findViewById(R.id.textView2eventdateedetails);
        textVieweventnameedetails = findViewById(R.id.textView2eventnameedetails);
        textVieweventdetailsedetails = findViewById(R.id.textView2eventdateedetails);
        textVieweventtimeedetails = findViewById(R.id.textView2eventtimeedetails);
        textVieweventlocationedetails = findViewById(R.id.textView2locationedetails);
        textVieweventinfoedetails = findViewById(R.id.textView2infoeventdetails);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String date = intent.getStringExtra("date");
        String location = intent.getStringExtra("location");
        String time = intent.getStringExtra("time");
        String info = intent.getStringExtra("info");

        textVieweventnameedetails.setText(name);
        textVieweventdateedetails.setText(date);
        textVieweventtimeedetails.setText(time);
        textVieweventlocationedetails.setText(location);
        textVieweventinfoedetails.setText(info);
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
