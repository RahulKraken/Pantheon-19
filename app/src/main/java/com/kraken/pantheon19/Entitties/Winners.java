package com.kraken.pantheon19.Entitties;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(tableName = "winners_table",
        foreignKeys = @ForeignKey(entity = Event.class, parentColumns = "event_id", childColumns = "event_id", onDelete = ForeignKey.CASCADE))
public class Winners {

    @ColumnInfo(name = "event_id")
    private int eventId;

    private String first;
    private String second;
    private String third;

    public Winners(int eventId, String first, String second, String third) {
        this.eventId = eventId;
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public int getEventId() {
        return eventId;
    }

    public String getFirst() {
        return first;
    }

    public String getSecond() {
        return second;
    }

    public String getThird() {
        return third;
    }
}
