package com.kraken.pantheon19.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kraken.pantheon19.R;

public class HomepageActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "HomepageActivity";

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
        ImageButton youtubeBtn = findViewById(R.id.youtube_btn);

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
        youtubeBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.info_button:
                Log.d(TAG, "onClick: info btn clicked");
                break;
            case R.id.flagship_list_button:
                Log.d(TAG, "onClick: flagship btn clicked");
                startActivity(new Intent(this, FlagshipEventActivity.class));
                break;
            case R.id.event_list_button:
                startActivity(new Intent(this, EventsActivity.class));
                break;
            case R.id.guest_speaker_btn:
                Log.d(TAG, "onClick: guest speaker btn");
                break;
            case R.id.leaderboard_btn:
                Log.d(TAG, "onClick: leader board btn");
                break;
            case R.id.sponsors_btn:
                Log.d(TAG, "onClick: sponsors btn");
                break;
            case R.id.facebook_btn:
                Log.d(TAG, "onClick: facebook btn");
                break;
            case R.id.instagram_btn:
                Log.d(TAG, "onClick: instagram btn");
                break;
            case R.id.web_btn:
                Log.d(TAG, "onClick: web btn");
                break;
            case R.id.youtube_btn:
                Log.d(TAG, "onClick: youtube btn");
                break;
        }
    }
}
