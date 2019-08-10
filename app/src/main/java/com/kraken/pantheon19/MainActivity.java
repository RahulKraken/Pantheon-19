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
import com.kraken.pantheon19.Repositories.EventRepository;
import com.kraken.pantheon19.Repositories.TriviaRepository;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
