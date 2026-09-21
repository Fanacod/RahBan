package com.example.rahban3;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.BLACK);
        setContentView(R.layout.activity_main);

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


        //start btn
        Button edtSchoolSearch = findViewById(R.id.edtSchoolSearch);

        edtSchoolSearch.setOnClickListener(v->{
            Intent intent = new Intent(MainActivity.this, activity_search_school.class);
            startActivity(intent);
            finish();
        });
    }
}