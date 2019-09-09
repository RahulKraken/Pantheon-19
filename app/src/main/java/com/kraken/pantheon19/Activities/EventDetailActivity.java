package com.kraken.pantheon19.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kraken.pantheon19.Entities.Event;
import com.kraken.pantheon19.R;

public class EventDetailActivity extends AppCompatActivity {
    private static final String TAG = "EventDetailActivity";

    private Event event;
    private TextView scoreOne, scoreTwo, scoreThree, venue, time, desc;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);

        // add app bar
        Toolbar toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Event title");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        scoreOne = findViewById(R.id.tv_score_one);
        scoreTwo = findViewById(R.id.tv_score_two);
        scoreThree = findViewById(R.id.tv_score_three);

        venue = findViewById(R.id.tv_venue);
        time = findViewById(R.id.tv_time);
        desc = findViewById(R.id.tv_desc);
        imageView = findViewById(R.id.image_main);

        // get intent
        event = (Event) getIntent().getSerializableExtra(getResources().getString(R.string.event_intent_pass_key));
        Log.d(TAG, "onCreate: " + event);

        setupViews();
    }

    @Override
    public boolean onSupportNavigateUp() {
        Log.d(TAG, "onSupportNavigateUp: back pressed");
        finish();
        return true;
    }

    private void setupViews() {
        if (!event.getTag().equals("flagship")) imageView.setVisibility(View.INVISIBLE);

        // app bar title
        if (getSupportActionBar() != null) getSupportActionBar().setTitle(event.getTitle());
        venue.setText(event.getVenue() != null ? event.getVenue() : "-");
        time.setText(event.getTime() != null ? event.getTime() : "-");
        desc.setText(event.getDescription() != null ? event.getDescription() : "-");
    }
}
