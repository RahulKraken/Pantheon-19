package com.kraken.pantheon19.Activities;

import android.app.Activity;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kraken.pantheon19.Adapters.SponsorsRecyclerViewAdapter;
import com.kraken.pantheon19.Entities.Event;
import com.kraken.pantheon19.Entities.SharedThemePref;
import com.kraken.pantheon19.R;

import java.util.ArrayList;
import java.util.List;

public class SponsorsActivity extends AppCompatActivity {

    private static final String TAG = "SponsorsEventActivity";
    private RecyclerView recyclerView;
    private List<Event> events;
    SharedThemePref sharedThemePref;
    CoordinatorLayout sponsorLayout;
    Toolbar toolbar;
    TextView coming_soon_sponsor;
    boolean isDark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sponsors);

        // TODO : app bar
        coming_soon_sponsor=findViewById(R.id.comingsoon_sponsors);
        sponsorLayout=findViewById(R.id.sponsors_list_layout);
        toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Sponsors");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        sharedThemePref=new SharedThemePref();

        //set theme
        isDark = sharedThemePref.getThemeStatePref(this);
        if(isDark) setDarkTheme();
        else setLightTheme();

        //recyclerView = findViewById(R.id.sponsors_recycler_view);

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
    TODO : replace with sponsors list
     */
    private void setupEventList() {
        events = new ArrayList<>();
        events.add(new Event(85, "kjdsfl", "skdjf", "kdsjfl", "10",
                "kldsj", "2", "4", "lkfsjdflks", "formal", "1 hr"));
        events.add(new Event(85, "kjdsfl", "skdjf", "kdsjfl", "10",
                "kldsj", "2", "4", "lkfsjdflks", "formal", "1 hr"));
        events.add(new Event(85, "kjdsfl", "skdjf", "kdsjfl", "10",
                "kldsj", "2", "4", "lkfsjdflks", "formal", "1 hr"));
        events.add(new Event(85, "kjdsfl", "skdjf", "kdsjfl", "10",
                "kldsj", "2", "4", "lkfsjdflks", "formal", "1 hr"));
        events.add(new Event(85, "kjdsfl", "skdjf", "kdsjfl", "10",
                "kldsj", "2", "4", "lkfsjdflks", "formal", "1 hr"));
        events.add(new Event(85, "kjdsfl", "skdjf", "kdsjfl", "10",
                "kldsj", "2", "4", "lkfsjdflks", "formal", "1 hr"));
        events.add(new Event(85, "kjdsfl", "skdjf", "kdsjfl", "10",
                "kldsj", "2", "4", "lkfsjdflks", "formal", "1 hr"));
    }

    private void setupRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        SponsorsRecyclerViewAdapter adapter = new SponsorsRecyclerViewAdapter(this, events);

        // set on recycler view
        Log.d(TAG, "setupRecyclerView: inflating speakers recycler view");
        //recyclerView.setLayoutManager(layoutManager);
        //recyclerView.setAdapter(adapter);
    }

    public void setDarkTheme() {
        sponsorLayout.setBackgroundColor(getResources().getColor(R.color.md_black_1000));
        coming_soon_sponsor.setTextColor(getResources().getColor(R.color.md_white_1000));
        toolbar.setTitleTextColor(getResources().getColor(R.color.md_white_1000));
        toolbar.setBackgroundColor(getResources().getColor(R.color.md_black_1000));
        toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP);
    }

    public void setLightTheme() {
        sponsorLayout.setBackgroundColor(getResources().getColor(R.color.md_white_1000));
        coming_soon_sponsor.setTextColor(getResources().getColor(R.color.md_black_1000));
        toolbar.setTitleTextColor(getResources().getColor(R.color.md_black_1000));
        toolbar.setBackgroundColor(getResources().getColor(R.color.md_white_1000));
        toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.md_black_1000), PorterDuff.Mode.SRC_ATOP);
    }
}
