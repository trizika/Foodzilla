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
        textVieweventnameedetails = findViewById(R.id.textVieweventnameedetails);
        textVieweventdetailsedetails = findViewById(R.id.textVieweventdetailsedetails);
        textVieweventtimeedetails = findViewById(R.id.textVieweventtimeedetails);
        textVieweventlocationedetails = findViewById(R.id.textVieweventlocationedetails);
        textVieweventinfoedetails = findViewById(R.id.textVieweventinfoedetails);
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
