package com.example.foodzilla;

import android.graphics.Bitmap;

//...
public class FoodSpottingsClass {
    String location;
    Bitmap picture;

    public FoodSpottingsClass() {
    }

    public FoodSpottingsClass(String location, Bitmap picture) {
        this.location = location;
        this.picture = picture;
    }
}



