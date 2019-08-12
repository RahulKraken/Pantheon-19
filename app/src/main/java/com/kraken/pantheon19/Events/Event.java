package com.kraken.pantheon19.Events;

public class Event {
    private String EventName;
    private String EventDescription;
    public Event(String EventName, String EventDescription) {
        this.EventName=EventName;
        this.EventDescription= EventDescription;
    }
    public String getEventName() {
        return EventName;
    }
    public void setEventName(String EventName) {
        this.EventName=EventName;
    }
    public String getEventDescription() {
        return EventDescription;
    }
    public void setEventDescription(String EventDescription) {
        this.EventDescription = EventDescription;
    }
}
