package com.example.foodzilla; //t

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class AvailableEvents extends AppCompatActivity implements View.OnClickListener {


    TextView date1, date2, date3, date4, name1, name2, name3, name4;
    Button buttonGoToHostEvent, buttonNOTHINGme2, buttonSwitchMenuAvme2, buttonShowAvailableEvents;
    public RecyclerView recyclerView; //recycler view variable
    public RecyclerView.LayoutManager layoutManager; //layout manager for recycler view, need this for a recyclerview
    public List<Contact> contacts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_events);

        buttonNOTHINGme2 = findViewById(R.id.buttonMyEventsCr2);
        buttonSwitchMenuAvme2 = findViewById(R.id.buttonAvailableEventsCr2);
        buttonGoToHostEvent = findViewById(R.id.buttonRSVPForEvent1);
        buttonShowAvailableEvents = findViewById(R.id.buttonShowAvailableEvents);

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
        final Boolean boolFlag = true;
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
            final DatabaseReference myRef = database.getReference("Events");

         /*  myRef.addListenerForSingleValueEvent(new ValueEventListener() {
               @Override
               public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                   ArrayList<Contact> contacts = new ArrayList<>();
                   for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                          EventClass e = dataSnapshot.getValue(EventClass.class);
                            contacts.add(new Contact(e.eventname, e.eventdate));
                           //  Toast.makeText(AvailableEvents.this, e.eventname + e.eventtime, Toast.LENGTH_SHORT).show();
                       Toast.makeText(AvailableEvents.this, dataSnapshot.getKey(), Toast.LENGTH_SHORT).show();
                        }
                   recyclerView = findViewById(R.id.recyclerView); //Link recyclerview variable to xml
                    RecyclerViewAdapter adapter = new RecyclerViewAdapter(contacts, AvailableEvents.this); //Linking the adapter to recyclerView,
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(AvailableEvents.this)); //Setting the layout manager, commonly

               }

               @Override
               public void onCancelled(@NonNull DatabaseError databaseError) {

               }
           });*/


         myRef.addChildEventListener(new ChildEventListener() {
             @Override
             public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                 ArrayList<Contact> contacts = new ArrayList<>();

                 EventClass e = dataSnapshot.getValue(EventClass.class);
                 contacts.add(new Contact(e.eventname, e.eventdate));

                // long cc = dataSnapshot.getChildrenCount();
                // long loopCounter = 1;
                       // for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                         //                                      // Toast.makeText(AvailableEvents.this, e.eventname + e.eventtime, Toast.LENGTH_SHORT).show();
                           // }
                       // }


                  //  EventClass e = dataSnapshot.getValue(EventClass.class);
////                   // contacts.add(new Contact(e.eventname, e.eventdate));
////                   // Toast.makeText(AvailableEvents.this, e.eventname + e.eventtime, Toast.LENGTH_SHORT).show();
////
                    recyclerView = findViewById(R.id.recyclerView); //Link recyclerview variable to xml
                    RecyclerViewAdapter adapter = new RecyclerViewAdapter(contacts, AvailableEvents.this); //Linking the adapter to recyclerView,
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(AvailableEvents.this)); //Setting the layout manager, commonly

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





///*
////            myRef.addChildEventListener(new ChildEventListener() {
////                @Override
////                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
////
////                    ArrayList<Contact> contacts = new ArrayList<>();
////
////                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
////                            EventClass e = dataSnapshot.getValue(EventClass.class);
////                            contacts.add(new Contact(e.eventname, e.eventdate));
////                            // Toast.makeText(AvailableEvents.this, e.eventname + e.eventtime, Toast.LENGTH_SHORT).show();
////                        }
////
////
////                  //  EventClass e = dataSnapshot.getValue(EventClass.class);
////                   // contacts.add(new Contact(e.eventname, e.eventdate));
////                   // Toast.makeText(AvailableEvents.this, e.eventname + e.eventtime, Toast.LENGTH_SHORT).show();
////
////                    recyclerView = findViewById(R.id.recyclerView); //Link recyclerview variable to xml
////                    RecyclerViewAdapter adapter = new RecyclerViewAdapter(contacts, AvailableEvents.this); //Linking the adapter to recyclerView,
////                    recyclerView.setAdapter(adapter);
////                    recyclerView.setLayoutManager(new LinearLayoutManager(AvailableEvents.this)); //Setting the layout manager, commonly
////
////                }
////
////                @Override
////                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
////
////                }
////
////                @Override
////                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
////
////                }
////
////                @Override
////                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
////
////                }
////
////                @Override
////                public void onCancelled(@NonNull DatabaseError databaseError) {
////
////                }
////            });
////
////
//*/


            //basically going to have to create a for loop here that puts the event name and date
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    ArrayList<Contact> contacts = new ArrayList<>();
                   // Toast.makeText(AvailableEvents.this, String.valueOf( dataSnapshot.getChildrenCount()), Toast.LENGTH_SHORT).show();

//                    EventClass e = dataSnapshot.getValue(EventClass.class);
//                    contacts.add(new Contact(e.eventname, e.eventdate));
//                    Toast.makeText(AvailableEvents.this, e.eventname + e.eventtime, Toast.LENGTH_SHORT).show();



           /*         for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                        EventClass e = dataSnapshot.getValue(EventClass.class);
                        contacts.add(new Contact(e.eventname, e.eventdate));
                        Toast.makeText(AvailableEvents.this, e.eventname + e.eventtime, Toast.LENGTH_SHORT).show();
                    }

                    recyclerView = findViewById(R.id.recyclerView); //Link recyclerview variable to xml
                    RecyclerViewAdapter adapter = new RecyclerViewAdapter(contacts, AvailableEvents.this); //Linking the adapter to recyclerView,
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(AvailableEvents.this)); //Setting the layout manager, commonly
*/                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });


            /*recyclerView = findViewById(R.id.recyclerView); //Link recyclerview variable to xml
            RecyclerViewAdapter adapter = new RecyclerViewAdapter(contacts, this); //Linking the adapter to recyclerView,
            //check out the RecyclerViewAdapter (this is the hard part)
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this)); //Setting the layout manager, commonly used is linear
*/        }
    }
}
