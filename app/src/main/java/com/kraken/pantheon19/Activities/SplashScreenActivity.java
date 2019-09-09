package com.kraken.pantheon19.Activities;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.kraken.pantheon19.NetworkServices.ApiService;
import com.kraken.pantheon19.R;
import com.kraken.pantheon19.Utils.Constants;

public class SplashScreenActivity extends AppCompatActivity {

    public static final int SPLASH_TIME_OUT=2000;
    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        lottieAnimationView = findViewById(R.id.walking_animation);

        // EXPERIMENT
        ApiService service = new ApiService();
        service.getFormalEvents(this, Constants.FORMAL_EVENTS_API);
        service.getInformalEvents(this, Constants.INFORMAL_EVENTS_API);
        service.getFlagshipEvents(this, Constants.FLAGSHIP_EVENTS_API);

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

