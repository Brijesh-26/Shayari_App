package com.codewithharry.shayari;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.TimeAnimator;
import android.content.Intent;
import android.os.Bundle;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    LottieAnimationView lottieAnimationView;
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        getSupportActionBar().hide();

        lottieAnimationView= findViewById(R.id.splash_beat);
        lottieAnimationView.animate().translationY(1400).setDuration(2000).setStartDelay(3000);

        timer= new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent= new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2500);


    }
}