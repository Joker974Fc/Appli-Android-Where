package com.example.where;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
//Splash Screen
//ecran de chargement
public class SplashActivity extends Activity {
    private static int time=1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //son demarrage
        MediaPlayer start = MediaPlayer.create(this,R.raw.start);
        start.start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        },time);
    }
}
