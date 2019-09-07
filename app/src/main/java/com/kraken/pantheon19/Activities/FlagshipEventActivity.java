package com.kraken.pantheon19.Activities;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.kraken.pantheon19.Adapters.FlagshipRecyclerViewAdapter;
import com.kraken.pantheon19.Entities.Event;
import com.kraken.pantheon19.R;
import com.kraken.pantheon19.Repositories.EventRepository;
import com.kraken.pantheon19.ViewModels.FlagshipActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class FlagshipEventActivity extends AppCompatActivity {
    private static final String TAG = "FlagshipEventActivity";

    private RecyclerView recyclerView;
    private FlagshipActivityViewModel flagshipActivityViewModel;
    private FlagshipRecyclerViewAdapter adapter;

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

        // setup view model
        flagshipActivityViewModel = ViewModelProviders.of(this).get(FlagshipActivityViewModel.class);

        // observe event list now
        flagshipActivityViewModel.getEventList().observe(this, new Observer<List<Event>>() {
            @Override
            public void onChanged(List<Event> events) {
                Log.d(TAG, "onChanged: data changed");
                adapter.setEventList(events);

                for (Event e : events) {
                    Log.d(TAG, "onChanged: " + e);
                }
            }
        });

        recyclerView = findViewById(R.id.flagship_recycler_view);

        setupRecyclerView();
    }

    private void setupRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        adapter = new FlagshipRecyclerViewAdapter(this);

        // set on recycler view
        Log.d(TAG, "setupRecyclerView: inflating recycler view");
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        // snap behavior for recycler view
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
    }
}
