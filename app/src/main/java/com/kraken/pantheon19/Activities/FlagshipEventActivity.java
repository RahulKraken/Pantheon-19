package com.kraken.pantheon19.Activities;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.kraken.pantheon19.Adapters.FlagshipRecyclerViewAdapter;
import com.kraken.pantheon19.Entities.Event;
import com.kraken.pantheon19.R;

import java.util.ArrayList;
import java.util.List;

public class FlagshipEventActivity extends AppCompatActivity {
    private static final String TAG = "FlagshipEventActivity";

    private RecyclerView recyclerView;
    private List<Event> events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flagship_event);

        // TODO : app bar
        Toolbar toolbar = findViewById(R.id.flagship_page_toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(getResources().getString(R.string.flagship_activity_title));
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        recyclerView = findViewById(R.id.flagship_recycler_view);

        setupEventList();
        setupRecyclerView();
    }

    /*
    create list of events
    TODO : replace with repository call
     */
    private void setupEventList() {
        events = new ArrayList<>();
        events.add(new Event(85, "madarchod", "bhosdika", "lauda", "gandu", "betichod", 2, 4, "bhosdiwala"));
        events.add(new Event(85, "kjdsfl", "skdjf", "kdsjfl", "ksdjfl", "kldsj", 2, 4, "lkfsjdflks"));
        events.add(new Event(85, "kjdsfl", "skdjf", "kdsjfl", "ksdjfl", "kldsj", 2, 4, "lkfsjdflks"));
        events.add(new Event(85, "kjdsfl", "skdjf", "kdsjfl", "ksdjfl", "kldsj", 2, 4, "lkfsjdflks"));
        events.add(new Event(85, "kjdsfl", "skdjf", "kdsjfl", "ksdjfl", "kldsj", 2, 4, "lkfsjdflks"));
        events.add(new Event(85, "kjdsfl", "skdjf", "kdsjfl", "ksdjfl", "kldsj", 2, 4, "lkfsjdflks"));
        events.add(new Event(85, "kjdsfl", "skdjf", "kdsjfl", "ksdjfl", "kldsj", 2, 4, "lkfsjdflks"));
    }

    private void setupRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        FlagshipRecyclerViewAdapter adapter = new FlagshipRecyclerViewAdapter(this, events);

        // set on recycler view
        Log.d(TAG, "setupRecyclerView: inflating recycler view");
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        // snap behavior for recycler view
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
    }
}
