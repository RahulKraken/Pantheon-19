package com.kraken.pantheon19.Events;

public class Event {
    private String EventName;
    private String EventDescription;
    private String duration;
    private String startTime;
    public Event(String EventName, String EventDescription,String duration,String startTime) {
        this.duration=duration;
        this.startTime=startTime;
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
    public void setEventDescription(String EventDescription) { this.EventDescription = EventDescription; }
    public String getEventDuration() { return duration; }
    public void setEventDuration(String duration) { this.duration=duration; }
    public String getEventStartTime() {  return startTime; }
    public void setEventStartTime(String startTime) { this.startTime=startTime; }
}
