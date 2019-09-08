package com.kraken.pantheon19.Activities;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kraken.pantheon19.Adapters.SpeakersRecyclerViewAdapter;
import com.kraken.pantheon19.Entities.Event;
import com.kraken.pantheon19.Entities.Speaker;
import com.kraken.pantheon19.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SpeakersListActivity extends AppCompatActivity {
    private static final String TAG = "SpeakersEventActivity";
    private RecyclerView recyclerView;
    private List<Speaker> speakers;

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

    /*
    create list of speakers
    TODO : replace with repository call
     */
    private void setupEventList() {
        speakers = new ArrayList<>();
        speakers.add(new Speaker("Rahul", "Cloud computing and distributed systems expoer", "13:00", "CAT Hall", "fb.com/rahulkraken", "linkedin.com/rahulkraken", "twitter.com/rahulkraken", R.drawable.guest_lecture));
        speakers.add(new Speaker("Rahul", "Cloud computing and distributed systems expoer", "13:00", "CAT Hall", "fb.com/rahulkraken", "linkedin.com/rahulkraken", "twitter.com/rahulkraken", R.drawable.guest_lecture));
        speakers.add(new Speaker("Rahul", "Cloud computing and distributed systems expoer", "13:00", "CAT Hall", "fb.com/rahulkraken", "linkedin.com/rahulkraken", "twitter.com/rahulkraken", R.drawable.guest_lecture));
        speakers.add(new Speaker("Rahul", "Cloud computing and distributed systems expoer", "13:00", "CAT Hall", "fb.com/rahulkraken", "linkedin.com/rahulkraken", "twitter.com/rahulkraken", R.drawable.guest_lecture));
        speakers.add(new Speaker("Rahul", "Cloud computing and distributed systems expoer", "13:00", "CAT Hall", "fb.com/rahulkraken", "linkedin.com/rahulkraken", "twitter.com/rahulkraken", R.drawable.guest_lecture));
        speakers.add(new Speaker("Rahul", "Cloud computing and distributed systems expoer", "13:00", "CAT Hall", "fb.com/rahulkraken", "linkedin.com/rahulkraken", "twitter.com/rahulkraken", R.drawable.guest_lecture));
    }

    private void setupRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        SpeakersRecyclerViewAdapter adapter = new SpeakersRecyclerViewAdapter(this, speakers);

        // set on recycler view
        Log.d(TAG, "setupRecyclerView: inflating speakers recycler view");
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
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
}
