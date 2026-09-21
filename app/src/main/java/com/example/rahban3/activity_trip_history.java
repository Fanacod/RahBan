package com.example.rahban3;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rahban3.Adapter.TripAdapter;
import com.example.rahban3.Model.Trip;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class activity_trip_history extends AppCompatActivity {

    RecyclerView recyclerTrips;
    TripAdapter tripAdapter;
    ArrayList<Trip> tripList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.BLACK);
        setContentView(R.layout.activity_trip_history);
        //menuu
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




        // RecyclerView
        recyclerTrips = findViewById(R.id.recyclerTrips);

        recyclerTrips.setLayoutManager(
                new LinearLayoutManager(this)
        );


        // trip list
        tripList = new ArrayList<>();

        tripList.add(new Trip("۱۴۰۴/۰۶/۲۲", "مدرسه ← منزل", "۰۷:۱۰ - ۰۷:۳۵", "انجام شد"));
        tripList.add(new Trip("۱۴۰۴/۰۶/۲۲", "مدرسه ← منزل", "۰۷:۱۰ - ۰۷:۳۵", "انجام شد"));
        tripList.add(new Trip("۱۴۰۴/۰۶/۲۲", "مدرسه ← منزل", "۰۷:۱۰ - ۰۷:۳۵", "انجام شد"));
        tripList.add(new Trip("۱۴۰۴/۰۶/۲۲", "مدرسه ← منزل", "۰۷:۱۰ - ۰۷:۳۵", "انجام شد"));
        tripList.add(new Trip("۱۴۰۴/۰۶/۲۲", "مدرسه ← منزل", "۰۷:۱۰ - ۰۷:۳۵", "انجام شد"));
        tripList.add(new Trip("۱۴۰۴/۰۶/۲۲", "مدرسه ← منزل", "۰۷:۱۰ - ۰۷:۳۵", "انجام شد"));
        tripList.add(new Trip("۱۴۰۴/۰۶/۲۲", "مدرسه ← منزل", "۰۷:۱۰ - ۰۷:۳۵", "انجام شد"));
        tripList.add(new Trip("۱۴۰۴/۰۶/۲۲", "مدرسه ← منزل", "۰۷:۱۰ - ۰۷:۳۵", "انجام شد"));
        tripList.add(new Trip("۱۴۰۴/۰۶/۲۲", "مدرسه ← منزل", "۰۷:۱۰ - ۰۷:۳۵", "انجام شد"));


        tripAdapter = new TripAdapter(tripList);
        recyclerTrips.setAdapter(tripAdapter);
    }
}