package com.example.foodzilla;

import android.widget.Button;

//user class
public class Person {

    String firstname;
    String lastname;
    String email;
    Boolean notifications;

    public Person() {
    }

    public Person(String firstname, String lastname, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;


    }

    public Boolean getNotifications() {
        return notifications;
    }


    public void setNotifications(Boolean notifications) {
        this.notifications = notifications;
    }
}



