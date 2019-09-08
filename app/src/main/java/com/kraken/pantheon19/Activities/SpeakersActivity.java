package com.kraken.pantheon19.Activities;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kraken.pantheon19.Adapters.SpeakersRecyclerViewAdapter;
import com.kraken.pantheon19.Entities.Event;
import com.kraken.pantheon19.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SpeakersActivity extends AppCompatActivity {
    private static final String TAG = "SpeakersEventActivity";
    private RecyclerView recyclerView;
    private List<Event> events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speakers_list);

        // TODO : app bar
        Toolbar toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Speakers");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        recyclerView = findViewById(R.id.speakers_recycler_view);

        setupEventList();
        setupRecyclerView();
    }
    @Override
    public boolean onSupportNavigateUp() {
        Log.d(TAG, "onSupportNavigateUp: back pressed");
        finish();
        return true;
    }

    private String setRandomColor() {
        Random r=new Random();
        int rand=r.nextInt(5 - 1)+1;
        if(rand==1) return "#4fC3F7"; //blue
        else if(rand==2) return "#76FF03"; //green
        else if(rand==3) return "#FFFF00"; //yellow
        else if(rand==4) return "#FF0000"; //red
        else return "#FFFFFF";
    }
    /*
    create list of events
    TODO : replace with repository call
     */
    private void setupEventList() {
        events = new ArrayList<>();
        events.add(new Event(85, "madarchod", "bhosdika", "lauda", "gandu",
                "10", "betichod", 2, 4, "bhosdiwala",setRandomColor()));
        events.add(new Event(85, "kjdsfl", "skdjf", "kdsjfl", "ksdjfl","10",
                "kldsj", 2, 4, "lkfsjdflks",setRandomColor()));
        events.add(new Event(85, "kjdsfl", "skdjf", "kdsjfl", "ksdjfl","10",
                "kldsj", 2, 4, "lkfsjdflks",setRandomColor()));
        events.add(new Event(85, "kjdsfl", "skdjf", "kdsjfl", "ksdjfl","10",
                "kldsj", 2, 4, "lkfsjdflks",setRandomColor()));
        events.add(new Event(85, "kjdsfl", "skdjf", "kdsjfl", "ksdjfl","10",
                "kldsj", 2, 4, "lkfsjdflks",setRandomColor()));
        events.add(new Event(85, "kjdsfl", "skdjf", "kdsjfl", "ksdjfl","10",
                "kldsj", 2, 4, "lkfsjdflks",setRandomColor()));
        events.add(new Event(85, "kjdsfl", "skdjf", "kdsjfl", "ksdjfl","10",
                "kldsj", 2, 4, "lkfsjdflks",setRandomColor()));
    }

    private void setupRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        SpeakersRecyclerViewAdapter adapter = new SpeakersRecyclerViewAdapter(this, events);

        // set on recycler view
        Log.d(TAG, "setupRecyclerView: inflating speakers recycler view");
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
