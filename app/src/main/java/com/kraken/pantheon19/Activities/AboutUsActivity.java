package com.kraken.pantheon19.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.kraken.pantheon19.Entities.SharedThemePref;
import com.kraken.pantheon19.R;

public class AboutUsActivity extends AppCompatActivity {
    private static final String TAG = "AboutUsActivity";
    Toolbar toolbar;
    boolean isDark;
    SharedThemePref sharedThemePref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("About Us");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        sharedThemePref=new SharedThemePref();

        //set theme
        isDark = sharedThemePref.getThemeStatePref(this);
        if(isDark) setDarkTheme();
        else setLightTheme();
    }

    @Override
    public boolean onSupportNavigateUp() {
        Log.d(TAG, "onSupportNavigateUp: back pressed");
        finish();
        return true;
    }

    public void setDarkTheme() {
        toolbar.setTitleTextColor(getResources().getColor(R.color.md_white_1000));
        toolbar.setBackgroundColor(getResources().getColor(R.color.md_black_1000));
        toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.md_white_1000), PorterDuff.Mode.SRC_ATOP);
    }

    public void setLightTheme() {
        toolbar.setTitleTextColor(getResources().getColor(R.color.md_black_1000));
        toolbar.setBackgroundColor(getResources().getColor(R.color.md_white_1000));
        toolbar.getNavigationIcon().setColorFilter(getResources().getColor(R.color.md_black_1000), PorterDuff.Mode.SRC_ATOP);
    }
}
