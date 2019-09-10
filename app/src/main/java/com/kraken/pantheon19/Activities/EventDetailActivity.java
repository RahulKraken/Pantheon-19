package com.kraken.pantheon19.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.kraken.pantheon19.Entities.Event;
import com.kraken.pantheon19.R;
import com.kraken.pantheon19.Utils.Constants;
import com.kraken.pantheon19.Utils.StringUtils;

import java.util.List;

public class EventDetailActivity extends AppCompatActivity {
    private static final String TAG = "EventDetailActivity";

    private Event event;
    private TextView scoreOne, scoreTwo, scoreThree, venue, time, desc;
    private ImageView imageView;
    private LinearLayout contactLinearLayout;

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

        contactLinearLayout = findViewById(R.id.contacts_linear_layout);

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
        // app bar title
        if (getSupportActionBar() != null) getSupportActionBar().setTitle(event.getEventName());

        venue.setText(event.getVenue() != null ? event.getVenue() : "-");
        time.setText(event.getTiming() != null ? event.getTiming() : "-");
        desc.setText(event.getDescription() != null ? event.getDescription() : "-");

        switch (event.getTag()) {
            case "informal":
                setPoints(Constants.INFORMAL_POINTS);
                break;
            case "formal":
                setPoints(Constants.FORMAL_POINTS);
                break;
            case "flagship":
                setPoints(Constants.FLAGSHIP_POINTS);
                break;
        }

        addContactInfo();
    }

    private void addContactInfo() {
        List<String> contacts = StringUtils.parseContact(event.getCoordinators(), "\\,");
        for (String s : contacts) {
            TextView textView = (TextView) getLayoutInflater().inflate(R.layout.coordinator_item_row, null);
            textView.setText(s.trim());
            contactLinearLayout.addView(textView);
        }
    }

    private void setPoints(int[] points) {
        scoreOne.setText(String.valueOf(points[0]));
        scoreTwo.setText(String.valueOf(points[1]));
        scoreThree.setText(String.valueOf(points[2]));
    }
}
