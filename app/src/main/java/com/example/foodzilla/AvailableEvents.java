package com.example.foodzilla;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class AvailableEvents extends AppCompatActivity implements View.OnClickListener {


    TextView date1, date2, date3, date4, name1, name2, name3, name4;
    Button buttonGoToHostEvent, buttonNOTHINGme2, buttonSwitchMenuAvme2, buttonShowAvailableEvents;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_events);

        buttonNOTHINGme2 = findViewById(R.id.buttonMyEventsCr2);
        buttonSwitchMenuAvme2 = findViewById(R.id.buttonAvailableEventsCr2);
        buttonGoToHostEvent = findViewById(R.id.buttonGoToHostEvent);
        buttonShowAvailableEvents = findViewById(R.id.buttonShowAvailableEvents);

        date1 = findViewById(R.id.textviewEDate1);
        date2 = findViewById(R.id.textViewEDate2);
        date3 = findViewById(R.id.textViewEDate3);
        date4 = findViewById(R.id.textViewEDate4);

        name1 = findViewById(R.id.textViewEName1);
        name2 = findViewById(R.id.textViewEName2);
        name3 = findViewById(R.id.textViewEName3);
        name4 = findViewById(R.id.textViewEName4);

        buttonGoToHostEvent.setOnClickListener(this);
        buttonNOTHINGme2.setOnClickListener(this);
        buttonSwitchMenuAvme2.setOnClickListener(this);
        buttonShowAvailableEvents.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.cornermenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.itemSpottingMap) {
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
        if (view == buttonNOTHINGme2) {
            Intent myEventsIntent2 = new Intent(this, MyEvents.class);
            startActivity(myEventsIntent2);
        } else if (view == buttonSwitchMenuAvme2) {
            Intent availableEventsIntent2 = new Intent(this, AvailableEvents.class);
            startActivity(availableEventsIntent2);
        } else if (view == buttonGoToHostEvent) {
            Intent goToCreateEventIntent = new Intent(this, CreateEvent2.class);
            startActivity(goToCreateEventIntent);
        } else if (view == buttonShowAvailableEvents) {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Events");

            myRef.orderByChild("eventCreator").addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    String findKey = dataSnapshot.getKey();
                    EventClass foundEvent = dataSnapshot.getValue(EventClass.class);
                    String findDate = foundEvent.eventEndDateAndTime;
                    String findLocation = foundEvent.eventLocation;

                    date1.setText(findDate);
                    name1.setText(findLocation);
                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
    }
}
