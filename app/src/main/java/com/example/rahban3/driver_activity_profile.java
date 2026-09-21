package com.example.rahban3;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class driver_activity_profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.WHITE);
        setContentView(R.layout.activity_driver_profile);
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

        Button btnViewService = findViewById(R.id.btnViewService);
        btnViewService.setOnClickListener(v -> {
            Intent intent = new Intent(driver_activity_profile.this, driver_activity_service_students.class);
            startActivity(intent);
        });

    }
}