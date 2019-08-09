package com.kraken.pantheon19.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.kraken.pantheon19.Entities.Event;

@Dao
public interface EventDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertEvent(Event... events);

    @Update
    void updateEvent(Event event);

    @Delete
    void deleteEvent(Event event);

    @Query("DELETE FROM EVENT_TABLE")
    void deleteAllEvents();

    @Query("SELECT * FROM EVENT_TABLE WHERE event_id = :eventId")
    LiveData<Event> getEvent(int eventId);
}
