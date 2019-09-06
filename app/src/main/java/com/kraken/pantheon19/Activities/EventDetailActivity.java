package com.kraken.pantheon19.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;

import com.kraken.pantheon19.Entities.SharedPrefThemes;
import com.kraken.pantheon19.R;

public class EventDetailActivity extends AppCompatActivity {

    private static final String TAG = "EventDetailActivity";
    SharedPrefThemes sharedPrefThemes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPrefThemes=new SharedPrefThemes(this);
        if(sharedPrefThemes.loadNightModeState()) setTheme(R.style.AppTheme);
        else setTheme(R.style.LightTheme);
        setContentView(R.layout.activity_event_detail);

        // add app bar
        Toolbar toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Event title");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        Log.d(TAG, "onSupportNavigateUp: back pressed");
        finish();
        return true;
    }
}
