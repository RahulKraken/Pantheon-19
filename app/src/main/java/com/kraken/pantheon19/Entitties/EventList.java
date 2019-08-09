package com.kraken.pantheon19.Entitties;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(tableName = "event_list_table",
        foreignKeys = @ForeignKey(entity = Event.class, parentColumns = "event_id", childColumns = "event_id", onDelete = ForeignKey.CASCADE))
public class EventList {

    @ColumnInfo(name = "event_id")
    private int eventId;

    private String title;
    private String venue;
    private String time;
    private int day;

    public EventList(String title, int eventId, String venue, String time, int day) {
        this.title = title;
        this.eventId = eventId;
        this.venue = venue;
        this.time = time;
        this.day = day;
    }

    public String getTitle() {
        return title;
    }

    public int getEventId() {
        return eventId;
    }

    public String getVenue() {
        return venue;
    }

    public String getTime() {
        return time;
    }

    public int getDay() {
        return day;
    }
}
