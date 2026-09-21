package com.example.rahban3;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class activity_driver_profile1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.BLACK);

        setContentView(R.layout.activity_driver_profile1);
        //menu
        DrawerHelper.setup(this);
        // nav btm
        BottomNavigationView bottomNavigationView =
                findViewById(R.id.bottomNavigationView);

        BottomNavHelper.setup(
                this,
                bottomNavigationView,
                MainActivity.class,
                activity_live_tracking.class,
                activity_trip_history.class,
                activity_profile.class

        );


        // btn back
        ImageView btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(activity_driver_profile1.this , activity_school_services.class);
            startActivity(intent);
        });


        //request btn
        Button btnRequestService = findViewById(R.id.btnRequestService);
        btnRequestService.setOnClickListener(v -> {
            Intent intent = new Intent(activity_driver_profile1.this , activity_student_info.class);
            startActivity(intent);
        });
    }
}