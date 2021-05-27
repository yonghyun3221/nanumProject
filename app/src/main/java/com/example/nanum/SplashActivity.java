package com.example.nanum;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class SplashActivity extends AppCompatActivity {

    int SPLASH_VIEW_TIME = 2000;
    LottieAnimationView lottieAnimationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        lottieAnimationView = findViewById(R.id.lottie);
        lottieAnimationView.playAnimation();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
            }
        },SPLASH_VIEW_TIME);
    }
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}