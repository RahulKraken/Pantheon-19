package com.kraken.pantheon19.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.kraken.pantheon19.Entities.Winners;

@Dao
public interface WinnersDao {

    @Insert
    void insertWinner(Winners... winners);

    @Update
    void updateWinner(Winners winners);

    @Delete
    void deleteWinner(Winners winners);

    @Query("DELETE FROM WINNERS_TABLE")
    void deleteAllWinners();

    @Query("SELECT * FROM WINNERS_TABLE WHERE event_id = :eventId")
    void getWinner(int eventId);
}
