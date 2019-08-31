package com.kraken.pantheon19.Activities;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.kraken.pantheon19.Entities.SharedPrefThemes;
import com.kraken.pantheon19.R;

public class HomepageActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "HomepageActivity";
    SharedPrefThemes sharedPrefThemes;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        sharedPrefThemes=new SharedPrefThemes(this);
        if(sharedPrefThemes.loadNightModeState()) setTheme(R.style.AppTheme);
        else setTheme(R.style.LightTheme);
        super.onCreate(savedInstanceState);
        View decorview=getWindow().getDecorView();
        int uiOptions=View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorview.setSystemUiVisibility(uiOptions);
        setContentView(R.layout.activity_homepage);
        ImageButton infoBtn = findViewById(R.id.about_us);
        ImageButton flagshipBtn = findViewById(R.id.flagship_list_button);
        ImageButton eventsBtn = findViewById(R.id.event_note_button);
        ImageButton guestSpeakerBtn = findViewById(R.id.guest_speaker_btn);
        ImageButton leaderBoardBtn = findViewById(R.id.leaderboard_btn);
        ImageButton sponsorsBtn = findViewById(R.id.sponsors_btn);
        ImageButton facebookBtn = findViewById(R.id.facebook_button);
        ImageButton instagramBtn = findViewById(R.id.instagram);
        ImageButton webBtn = findViewById(R.id.website);
        ImageButton youtubeBtn = findViewById(R.id.youtube);
        ImageView share=findViewById(R.id.share_button);
        ImageButton event_note_button;
        ImageButton about_us_button;
        ImageButton sponser_btn;
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
        event_note_button=findViewById(R.id.event_note_button);
        Switch theme=findViewById(R.id.theme_button);
        if(sharedPrefThemes.loadNightModeState()) theme.setChecked(true);
        theme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    sharedPrefThemes.setNightModeState(true);
                    recreate();
                }
                else {
                    sharedPrefThemes.setNightModeState(false);
                    recreate();
                }
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Hey check out pantheon app at playstore");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });
        event_note_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomepageActivity.this,EventsActivity.class);
                startActivity(intent);
            }
        });
        about_us_button=findViewById(R.id.about_us);
        about_us_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomepageActivity.this,AboutUsActivity.class);
                startActivity(intent);
            }
        });
        sponser_btn=findViewById(R.id.sponsors_btn);
        sponser_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomepageActivity.this,SponsersActicity.class);
                startActivity(intent);
            }
        });

        guestSpeakerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomepageActivity.this,SpeakersActivity.class);
                startActivity(intent);
            }
        });
        facebookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFacebookIntent();
            }
        });
        instagramBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInstagramIntent();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.about_us:
                Log.d(TAG, "onClick: info btn clicked");
                break;
            case R.id.flagship_list_button:
                Log.d(TAG, "onClick: flagship btn clicked");
                startActivity(new Intent(this, FlagshipEventActivity.class));
                break;
            case R.id.event_note_button:
                Log.d(TAG, "onClick: event list btn");
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
            case R.id.facebook_button:
                Log.d(TAG, "onClick: facebook btn");
                break;
            case R.id.instagram:
                Log.d(TAG, "onClick: instagram btn");
                break;
            case R.id.website:
                Log.d(TAG, "onClick: web btn");
                break;
            case R.id.youtube:
                Log.d(TAG, "onClick: youtube btn");
                break;
        }
    }

    public void openFacebookIntent() {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/860738913956082"));
            startActivity(intent);
        } catch(Exception e) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/860738913956082")));
        }
    }

    public void openInstagramIntent() {
        Uri uri = Uri.parse("https://instagram.com/pantheon_techfest?igshid=vyj3srrytza5");
        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);
        likeIng.setPackage("com.instagram.android");
        try {
            startActivity(likeIng);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://instagram.com/pantheon_techfest?igshid=vyj3srrytza5")));
        }
    }
}