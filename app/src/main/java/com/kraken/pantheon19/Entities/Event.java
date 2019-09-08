package com.kraken.pantheon19.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.kraken.pantheon19.R;

@Entity(tableName = "event_table")
public class Event {

    @PrimaryKey
    @ColumnInfo(name = "event_id")
    private int eventId;

    private String title;
    private String description;
    private String status;
    private String time;
    private String duration;
    private String venue;
    private int day;
    private String color;

    @ColumnInfo(name = "team_size")
    private int teamSize;
    private String coordinators;

    public Event(int eventId, String title, String description, String status, String time,String duration,
                 String venue, int day, int teamSize, String coordinators,String color) {
        this.eventId = eventId;
        this.title = title;
        this.description = description;
        this.status = status;
        this.time = time;
        this.venue = venue;
        this.day = day;
        this.teamSize = teamSize;
        this.coordinators = coordinators;
        this.duration=duration;
        this.color=color;
    }

    public int getEventId() {
        return eventId;
    }

    public String getTitle() { return title; }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public String getTime() {
        return time;
    }

    public String getVenue() { return venue; }

    public int getDay() {
        return day;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public String getCoordinators() {
        return coordinators;
    }

    public String getDuration(){return  duration;}

    public String getColor() { return color; }

    public int getImage() { return R.drawable.ic_launcher_background; }
}
