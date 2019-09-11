package com.kraken.pantheon19.Activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;

import com.kraken.pantheon19.R;
import com.kraken.pantheon19.Utils.Constants;

public class HomepageActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "HomepageActivity";
    private CustomTabsIntent customTabsIntent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        ImageButton infoBtn = findViewById(R.id.info_button);
        ImageButton flagshipBtn = findViewById(R.id.flagship_list_button);
        ImageButton eventsBtn = findViewById(R.id.event_list_button);
        ImageButton guestSpeakerBtn = findViewById(R.id.guest_speaker_btn);
        ImageButton leaderBoardBtn = findViewById(R.id.leaderboard_btn);
        ImageButton sponsorsBtn = findViewById(R.id.sponsors_btn);
        ImageButton facebookBtn = findViewById(R.id.facebook_btn);
        ImageButton instagramBtn = findViewById(R.id.instagram_btn);
        ImageButton webBtn = findViewById(R.id.web_btn);
        ImageView shareBtn = findViewById(R.id.home_share_btn);

        // set onclick listener
        infoBtn.setOnClickListener(this);
        flagshipBtn.setOnClickListener(this);
        eventsBtn.setOnClickListener(this);
        guestSpeakerBtn.setOnClickListener(this);
        leaderBoardBtn.setOnClickListener(this);
        sponsorsBtn.setOnClickListener(this);
        facebookBtn.setOnClickListener(this);
        instagramBtn.setOnClickListener(this);
        webBtn.setOnClickListener(this);
        shareBtn.setOnClickListener(this);

        // create custom tab
        customTabsIntent = new CustomTabsIntent.Builder()
                .setShowTitle(true)
                .build();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.info_button:
                startActivity(new Intent(this, AboutUsActivity.class));
                break;
            case R.id.flagship_list_button:
                startActivity(new Intent(this, FlagshipEventActivity.class));
                break;
            case R.id.event_list_button:
                startActivity(new Intent(this, EventsActivity.class));
                break;
            case R.id.guest_speaker_btn:
                startActivity(new Intent(this, SpeakersListActivity.class));
                break;
            case R.id.leaderboard_btn:
                startActivity(new Intent(this, LeaderboardActivity.class));
                break;
            case R.id.sponsors_btn:
                startActivity(new Intent(this, SponsorsActivity.class));
                break;
            case R.id.facebook_btn:
                launchCustomTab(Constants.FACEBOOK_URL);
                break;
            case R.id.instagram_btn:
                launchCustomTab(Constants.INSTAGRAM_URL);
                break;
            case R.id.web_btn:
                launchCustomTab(Constants.WEBSITE_URL);
                break;
            case R.id.home_share_btn:
                Log.d(TAG, "onClick: share btn");
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, "Hey check out pantheon's app on Google play store");
                intent.setType("text/plain");
                startActivity(Intent.createChooser(intent, "Cool, how do you wanna share..?"));
                break;
        }
    }

    private void launchCustomTab(String url) {
        Uri uri = Uri.parse(url);
        customTabsIntent.launchUrl(this, uri);
    }
}
