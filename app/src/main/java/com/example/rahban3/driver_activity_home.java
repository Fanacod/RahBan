package com.example.rahban3;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.card.MaterialCardView;

public class driver_activity_home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.WHITE);

        setContentView(R.layout.activity_driver_home);

        //menuu
        driver_DrawerHelper.setup(this);

        // nav btm
        BottomNavigationView driverBottomNavigation =
                findViewById(R.id.driverBottomNavigation);

        DriverBottomNavHelper.setup(
                this,
                driverBottomNavigation,
                driver_activity_home.class,
                driver_activity_service_students.class,
                driver_activity_notifications.class,
                driver_activity_profile.class

        );

        MaterialCardView cardTodayTrips = findViewById(R.id.cardTodayTrips);

        cardTodayTrips.setOnClickListener(v -> {
            Intent intent = new Intent(driver_activity_home.this, driver_activity_today_trips.class);
            startActivity(intent);
        });


        MaterialCardView cardDriverReport = findViewById(R.id.cardDriverReport);

        cardDriverReport.setOnClickListener(v -> {
            Intent intent = new Intent(driver_activity_home.this, driver_activity_live_tracking.class);
            startActivity(intent);
        });

        MaterialCardView cardDriverReq = findViewById(R.id.cardDriverReq);

        cardDriverReq.setOnClickListener(v -> {
            Intent intent = new Intent(driver_activity_home.this, driver_activity_requests.class);
            startActivity(intent);
        });



        Button btnStartService = findViewById(R.id.btnStartService);

        btnStartService.setOnClickListener(v -> {
            Intent intent = new Intent(driver_activity_home.this, driver_activity_live_tracking.class);
            startActivity(intent);
        });


        LinearLayout prof = findViewById(R.id.prof1);

        prof.setOnClickListener(v -> {
            Intent intent = new Intent(driver_activity_home.this, driver_activity_profile.class);
            startActivity(intent);
        });

    }
}