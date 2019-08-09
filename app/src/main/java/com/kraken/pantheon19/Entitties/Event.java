package com.kraken.pantheon19.Entitties;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "event_table")
public class Event {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "event_id")
    private int eventId;

    private String title;
    private String description;
    private String status;
    private String time;
    private String venue;

    @ColumnInfo(name = "team_size")
    private int teamSize;

    private String coordinators;

    public Event(String title, String description, String status, String time, String venue, int teamSize, String coordinators) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.time = time;
        this.venue = venue;
        this.teamSize = teamSize;
        this.coordinators = coordinators;
    }

    public void setId(int eventId) {
        this.eventId = eventId;
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

    public int getTeamSize() {
        return teamSize;
    }

    public String getCoordinators() {
        return coordinators;
    }
}
