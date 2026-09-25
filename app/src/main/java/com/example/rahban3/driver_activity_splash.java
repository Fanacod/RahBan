package com.example.rahban3;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

public class driver_activity_splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.WHITE);

        setContentView(R.layout.activity_driver_splash);

        String driverId = getSharedPreferences("rahban", MODE_PRIVATE)
                .getString("driver_id", null);

        Class<?> destination = (driverId != null)
                ? driver_activity_home.class
                : driver_activity_login.class;

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(driver_activity_splash.this, destination);
                startActivity(intent);
                finish();
            }
        }, 3000);

    }
}