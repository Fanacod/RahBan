package com.example.rahban3;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rahban3.Adapter.DriverTripAdapter;
import com.example.rahban3.Model.DriverTrip;
import com.example.rahban3.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class driver_activity_today_trips extends AppCompatActivity {

     RecyclerView recyclerTodayTrips;
     DriverTripAdapter adapter;
     ArrayList<DriverTrip> morningTrips;
     ArrayList<DriverTrip> eveningTrips;

     TextView btnMorning;
     TextView btnEvening;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setStatusBarColor(Color.WHITE);

        setContentView(R.layout.activity_driver_today_trips);
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

        recyclerTodayTrips = findViewById(R.id.recyclerTodayTrips);

        recyclerTodayTrips.setLayoutManager(
                new LinearLayoutManager(this)
        );

        btnMorning = findViewById(R.id.btnMorning);
        btnEvening = findViewById(R.id.btnEvening);

        createTrips();

        showMorningTrips();

        btnMorning.setOnClickListener(v -> {
            showMorningTrips();
        });

        btnEvening.setOnClickListener(v -> {
            showEveningTrips();
        });
    }


    private void createTrips() {

        morningTrips = new ArrayList<>();
        eveningTrips = new ArrayList<>();

        // سفرهای صبح

        morningTrips.add(
                new DriverTrip(
                        "سرویس شماره ۱۲",
                        "مدرسه فرزانگان",
                        "07:00",
                        "منزل ← مدرسه",
                        "۱۲ دانش‌آموز",
                        "در حال انجام",
                        true
                )
        );

        morningTrips.add(
                new DriverTrip(
                        "سرویس شماره ۱۸",
                        "مدرسه مهر",
                        "07:30",
                        "منزل ← مدرسه",
                        "۱۰ دانش‌آموز",
                        "در انتظار",
                        true
                )
        );


        // سفرهای عصر

        eveningTrips.add(
                new DriverTrip(
                        "سرویس شماره ۱۲",
                        "مدرسه فرزانگان",
                        "13:30",
                        "مدرسه ← منزل",
                        "۱۲ دانش‌آموز",
                        "در انتظار",
                        false
                )
        );

        eveningTrips.add(
                new DriverTrip(
                        "سرویس شماره ۱۸",
                        "مدرسه مهر",
                        "14:00",
                        "مدرسه ← منزل",
                        "۱۰ دانش‌آموز",
                        "در انتظار",
                        false
                )
        );
    }


    private void showMorningTrips() {

        btnMorning.setBackgroundResource(
                R.drawable.bg_tab_selected
        );

        btnMorning.setTextColor(Color.WHITE);

        btnEvening.setBackgroundColor(Color.TRANSPARENT);

        btnEvening.setTextColor(
                Color.parseColor("#52717A")
        );

        adapter = new DriverTripAdapter(morningTrips);

        recyclerTodayTrips.setAdapter(adapter);
    }


    private void showEveningTrips() {

        btnEvening.setBackgroundResource(
                R.drawable.bg_tab_selected
        );

        btnEvening.setTextColor(Color.WHITE);

        btnMorning.setBackgroundColor(Color.TRANSPARENT);

        btnMorning.setTextColor(
                Color.parseColor("#52717A")
        );

        adapter = new DriverTripAdapter(eveningTrips);

        recyclerTodayTrips.setAdapter(adapter);
    }
}