package com.example.foodzilla;

//cant commit ..
public class EventClass {
    String eventCreator;
    String eventSignedUpUser;
    Boolean eventFull;
    Integer eventCapacity;
    String eventLocation;
    String eventFoodServed;
    String eventStartDateAndTime;
    String eventEndDateAndTime;
    String eventLinkInfo;
    String eventStatus;

    public EventClass() {
    }

    public EventClass(String eventCreator, String eventSignedUpUser, Boolean eventFull, Integer eventCapacity, String eventLocation, String eventFoodServed, String eventStartDateAndTime, String eventEndDateAndTime, String eventLinkInfo, String eventStatus) {
        this.eventCreator = eventCreator;
        this.eventSignedUpUser = eventSignedUpUser;
        this.eventFull = eventFull;
        this.eventCapacity = eventCapacity;
        this.eventLocation = eventLocation;
        this.eventFoodServed = eventFoodServed;
        this.eventStartDateAndTime = eventStartDateAndTime;
        this.eventEndDateAndTime = eventEndDateAndTime;
        this.eventLinkInfo = eventLinkInfo;
        this.eventStatus = eventStatus;
    }
}



