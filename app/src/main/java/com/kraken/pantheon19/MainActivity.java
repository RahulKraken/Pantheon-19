package com.kraken.pantheon19;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.kraken.pantheon19.Dao.EventDao;
import com.kraken.pantheon19.Dao.TriviaDao;
import com.kraken.pantheon19.Dao.WinnerDao;
import com.kraken.pantheon19.Database.EventDatabase;
import com.kraken.pantheon19.Database.TriviaDatabase;
import com.kraken.pantheon19.Entities.Event;
import com.kraken.pantheon19.Entities.Trivia;
import com.kraken.pantheon19.Entities.Winner;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EventDatabase eventDatabase = EventDatabase.getInstance(this);
        EventDao eventDao = eventDatabase.eventDao();

        LiveData<List<Event>> eventLiveData = eventDao.getAllEvents();
        eventLiveData.observe(this, new Observer<List<Event>>() {
            @Override
            public void onChanged(List<Event> events) {
                if (events != null) {
                    for (Event e : events) Log.d(TAG, "onChanged: " + e.getTitle());
                }
            }
        });

        LiveData<Event> event = eventDao.getEvent(1);
        event.observe(this, new Observer<Event>() {
            @Override
            public void onChanged(Event event) {
                if (event != null) {
                    Log.d(TAG, "onChanged: " + event.getTitle());
                    Log.d(TAG, "onChanged: " + event.getDescription());
                    Log.d(TAG, "onChanged: " + event.getVenue());
                }
            }
        });

        TriviaDatabase triviaDatabase = TriviaDatabase.getInstance(this);
        TriviaDao triviaDao = triviaDatabase.triviaDao();

        LiveData<List<Trivia>> triviaLiveData = triviaDao.getAllTrivia();
        triviaLiveData.observe(this, new Observer<List<Trivia>>() {
            @Override
            public void onChanged(List<Trivia> trivias) {
                if (trivias != null) {
                    for (Trivia t : trivias) Log.d(TAG, "onChanged: " + t.getTitle());
                }
            }
        });

        WinnerDao winnerDao = eventDatabase.winnerDao();

        LiveData<Winner> winnerLiveData = winnerDao.getWinner(1);
        winnerLiveData.observe(this, new Observer<Winner>() {
            @Override
            public void onChanged(Winner winner) {
                if (winner != null) {
                    Log.d(TAG, "onChanged: " + winner.getFirst());
                }
            }
        });
    }
}
