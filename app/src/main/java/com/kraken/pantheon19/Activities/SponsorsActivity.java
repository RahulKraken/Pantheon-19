package com.kraken.pantheon19.Activities;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import com.kraken.pantheon19.Adapters.SponsorsRecyclerViewAdapter;
import com.kraken.pantheon19.Entities.Event;
import com.kraken.pantheon19.Entities.SharedPrefThemes;
import com.kraken.pantheon19.R;

import java.util.ArrayList;
import java.util.List;

public class SponsorsActivity extends AppCompatActivity {

    private static final String TAG = "SponsorsEventActivity";
    private RecyclerView recyclerView;
    private List<Event> events;
    SharedPrefThemes sharedPrefThemes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPrefThemes=new SharedPrefThemes(this);
        if(sharedPrefThemes.loadNightModeState()) setTheme(R.style.AppTheme);
        else setTheme(R.style.LightTheme);
        setContentView(R.layout.activity_sponsers_acticity);

        // TODO : app bar
        Toolbar toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Sponsors");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        recyclerView = findViewById(R.id.sponsors_recycler_view);

        setupEventList();
        setupRecyclerView();
    }
    @Override
    public boolean onSupportNavigateUp() {
        Log.d(TAG, "onSupportNavigateUp: back pressed");
        finish();
        return true;
    }

    /*
    create list of events
    TODO : replace with repository call
     */
    private void setupEventList() {
        events = new ArrayList<>();
        events.add(new Event(85, "madarchod", "bhosdika", "lauda", "gandu","10",
                "betichod", 2, 4, "bhosdiwala",""));
        events.add(new Event(85, "kjdsfl", "skdjf", "kdsjfl", "ksdjfl","10",
                "kldsj", 2, 4, "lkfsjdflks",""));
        events.add(new Event(85, "kjdsfl", "skdjf", "kdsjfl", "ksdjfl","10",
                "kldsj", 2, 4, "lkfsjdflks",""));
        events.add(new Event(85, "kjdsfl", "skdjf", "kdsjfl", "ksdjfl","10",
                "kldsj", 2, 4, "lkfsjdflks",""));
        events.add(new Event(85, "kjdsfl", "skdjf", "kdsjfl", "ksdjfl","10",
                "kldsj", 2, 4, "lkfsjdflks",""));
        events.add(new Event(85, "kjdsfl", "skdjf", "kdsjfl", "ksdjfl","10",
                "kldsj", 2, 4, "lkfsjdflks",""));
        events.add(new Event(85, "kjdsfl", "skdjf", "kdsjfl", "ksdjfl","10",
                "kldsj", 2, 4, "lkfsjdflks",""));
    }

    private void setupRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        SponsorsRecyclerViewAdapter adapter = new SponsorsRecyclerViewAdapter(this, events);

        // set on recycler view
        Log.d(TAG, "setupRecyclerView: inflating speakers recycler view");
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
