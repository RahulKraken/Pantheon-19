package com.kraken.pantheon19.Activities;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.kraken.pantheon19.NetworkServices.CallAPI;
import com.kraken.pantheon19.R;

public class SplashScreenActivity extends AppCompatActivity {

    public static final int SPLASH_TIME_OUT=2000;
    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        lottieAnimationView = findViewById(R.id.walking_animation);

        // ============ EXPERIMENT =============

        CallAPI callAPI = new CallAPI();
        callAPI.getEvents();

        // =====================================

        startCheckAnimation();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent wel = new Intent(SplashScreenActivity.this, HomepageActivity.class);
                startActivity(wel);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

    private void startCheckAnimation() {
        ValueAnimator animator = ValueAnimator.ofFloat(0f,1f).setDuration(2000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                lottieAnimationView.setProgress((Float)animation.getAnimatedValue());
            }
        });

        if(lottieAnimationView.getProgress() == 0f) {
            animator.start();
        } else {
            lottieAnimationView.setProgress(0f);
        }
    }
}
