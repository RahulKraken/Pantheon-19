package com.kraken.pantheon19.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.kraken.pantheon19.Entities.Trivia;

@Dao
public interface TriviaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTrivia(Trivia trivia);

    @Update
    void updateTrivia(Trivia trivia);

    @Delete
    void deleteTrivia(Trivia trivia);

    @Query("DELETE FROM TRIVIA_TABLE")
    void deleteAllTrivia();

    @Query("SELECT * FROM TRIVIA_TABLE WHERE trivia_id = :triviaId")
    LiveData<Trivia> getTrivia(int triviaId);
}
