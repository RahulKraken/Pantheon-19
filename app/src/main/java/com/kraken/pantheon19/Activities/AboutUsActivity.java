package com.kraken.pantheon19.Activities;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.kraken.pantheon19.Entities.SharedPrefThemes;
import com.kraken.pantheon19.R;

public class AboutUsActivity extends AppCompatActivity {

    private static final String TAG = "AboutUsActivity";
    SharedPrefThemes sharedPrefThemes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPrefThemes=new SharedPrefThemes(this);
        if(sharedPrefThemes.loadNightModeState()) setTheme(R.style.AppTheme);
        else setTheme(R.style.LightTheme);
        setContentView(R.layout.activity_about__us);
        Toolbar toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("About");
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
