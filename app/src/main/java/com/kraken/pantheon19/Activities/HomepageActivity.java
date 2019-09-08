package com.kraken.pantheon19.Activities;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kraken.pantheon19.R;

public class HomepageActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "HomepageActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        View decorView=getWindow().getDecorView();
        int uiOptions=View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
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
        ImageView share=findViewById(R.id.share_button);

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
        share.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.info_button:
                startActivity(new Intent(this, AboutUsActivity.class));
                break;
            case R.id.flagship_list_button:
                Log.d(TAG, "onClick: flagship btn");
                startActivity(new Intent(this, FlagshipEventActivity.class));
                break;
            case R.id.event_list_button:
                Log.d(TAG, "onClick: event list btn");
                startActivity(new Intent(HomepageActivity.this,EventsActivity.class));
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
                Log.d(TAG, "onClick: facebook btn");
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/860738913956082")));
                } catch(Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/860738913956082")));
                }
                break;
            case R.id.instagram_btn:
                Log.d(TAG, "onClick: instagram btn");
                Uri uri = Uri.parse("https://instagram.com/pantheon_techfest?igshid=vyj3srrytza5");
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);
                likeIng.setPackage("com.instagram.android");
                try { startActivity(likeIng); }
                catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://instagram.com/pantheon_techfest?igshid=vyj3srrytza5")));
                }
                break;
            case R.id.web_btn:
                Log.d(TAG, "onClick: web btn");
                break;
            case R.id.youtube_btn:
                Log.d(TAG, "onClick: youtube btn");
                break;
            case  R.id.share_button:
                Log.d(TAG, "onClick: share btn");
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Hey check out pantheon app at playstore");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
                break;
        }
    }
}