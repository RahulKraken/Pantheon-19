package com.kraken.pantheon19.Activities;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.kraken.pantheon19.R;

public class HomepageActivity extends AppCompatActivity {

    ImageButton eventsButton;
    ImageButton facebook,instagram,youtube,web;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        eventsButton=findViewById(R.id.event_note_button);
        facebook=findViewById(R.id.facebook_button);
        instagram=findViewById(R.id.instagram);
        youtube=findViewById(R.id.youtube);
        web=findViewById(R.id.website);
        eventsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomepageActivity.this,EventsActivity.class);
                startActivity(intent);
            }
        });
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFacebookIntent();
            }
        });
        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInstagramIntent();
            }
        });
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