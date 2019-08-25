package com.kraken.pantheon19.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "event_table")
public class Event {

    @PrimaryKey
    @ColumnInfo(name = "event_id")
    private int eventId;

    private String title;
    private String description;
    private String status;
    private String time;
    private String venue;
    private int day;
    private int flagship;

    @ColumnInfo(name = "team_size")
    private int teamSize;

    private String coordinators;

    public Event(int eventId, String title, String description, String status, String time, String venue, int day, int flagship, int teamSize, String coordinators) {
        this.eventId = eventId;
        this.title = title;
        this.description = description;
        this.status = status;
        this.time = time;
        this.venue = venue;
        this.day = day;
        this.flagship = flagship;
        this.teamSize = teamSize;
        this.coordinators = coordinators;
    }

    public int getFlagship() {
        return flagship;
    }

    public void setFlagship(int flagship) {
        this.flagship = flagship;
    }

    public int getEventId() {
        return eventId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public String getTime() {
        return time;
    }

    public String getVenue() {
        return venue;
    }

    public int getDay() {
        return day;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public String getCoordinators() {
        return coordinators;
    }
}
