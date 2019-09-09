package com.kraken.pantheon19.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "event_table")
public class Event implements Serializable {

    @PrimaryKey
    @ColumnInfo(name = "event_id")
    private int eventId;

    private String title;
    private String description;
    private String status;
    private String time;
    private String venue;
    private int day;

    @ColumnInfo(name = "team_size")
    private int teamSize;

    private String coordinators;
    private String tag;
    private String duration;

    public Event(int eventId, String title, String description, String status, String time, String venue, int day, int teamSize, String coordinators, String tag, String duration) {
        this.eventId = eventId;
        this.title = title;
        this.description = description;
        this.status = status;
        this.time = time;
        this.venue = venue;
        this.day = day;
        this.teamSize = teamSize;
        this.coordinators = coordinators;
        this.tag = tag;
        this.duration = duration;
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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId=" + eventId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", time='" + time + '\'' +
                ", venue='" + venue + '\'' +
                ", day=" + day +
                ", teamSize=" + teamSize +
                ", coordinators='" + coordinators + '\'' +
                ", tag='" + tag + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}
