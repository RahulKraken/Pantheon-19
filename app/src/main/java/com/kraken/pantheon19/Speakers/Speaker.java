package com.kraken.pantheon19.Speakers;

public class Speaker {
    private String SpeakerName;
    private String SpeakerDescription;
    private String duration;
    private String startTime;
    private String color;
    public Speaker(String SpeakerName, String SpeakerDescription,String duration,String startTime,String color) {
        this.duration=duration;
        this.startTime=startTime;
        this.SpeakerName =SpeakerName;
        this.SpeakerDescription= SpeakerDescription;
        this.color=color;
    }
    public String getSpeakerName() {
        return SpeakerName;
    }
    public void setSpeakertName(String SpeakerName) {
        this.SpeakerName=SpeakerName;
    }
    public String getSpeakerDescription() {
        return SpeakerDescription;
    }
    public void setSpeakerDescription(String SpeakerDescription) { this.SpeakerDescription = SpeakerDescription; }
    public String getSpeakertDuration() { return duration; }
    public void setSpeakerDuration(String duration) { this.duration=duration; }
    public String getSpeakerStartTime() {  return startTime; }
    public void setSpeakerStartTime(String startTime) { this.startTime=startTime; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color=color; }
}
