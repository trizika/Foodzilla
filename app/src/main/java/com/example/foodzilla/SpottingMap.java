package com.example.foodzilla;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class SpottingMap extends AppCompatActivity implements View.OnClickListener, OnMapReadyCallback, GoogleMap.OnMapClickListener {

    Button addFoodSpotting;

    GoogleMap gmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spotting_map);

        addFoodSpotting = findViewById(R.id.buttonSubmitsmap);

        SupportMapFragment supportMapFragment = (SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.mapViewsmap);

        supportMapFragment.getMapAsync(this);

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

    @Override
    public void onClick(View view) {

        if (view == addFoodSpotting) {

            Intent addspottingintent = new Intent(SpottingMap.this, ReportSpotting.class);

            startActivity(addspottingintent);

        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        gmap = googleMap;

        gmap.setOnMapClickListener(this);

    }

    @Override
    public void onMapClick(LatLng latLng) {

    }
}
