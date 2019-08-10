package com.kraken.pantheon19.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.kraken.pantheon19.Entities.Trivia;

import java.util.List;

@Dao
public interface TriviaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Trivia trivia);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(Trivia trivia);

    @Delete
    void delete(Trivia trivia);

    @Query("DELETE FROM TRIVIA_TABLE")
    void deleteAllTrivia();

    @Query("SELECT * FROM TRIVIA_TABLE ORDER BY trivia_id DESC LIMIT 1")
    LiveData<Trivia> getTrivia();

    @Query("SELECT * FROM TRIVIA_TABLE ORDER BY trivia_id DESC")
    LiveData<List<Trivia>> getAllTrivia();
}
