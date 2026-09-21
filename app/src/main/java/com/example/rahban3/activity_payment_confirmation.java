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

public class activity_payment_confirmation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.BLACK);
        setContentView(R.layout.activity_payment_confirmation);
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



        Button btnPayAndActivate = findViewById(R.id.btnPayAndActivate);
        btnPayAndActivate.setOnClickListener(v->{
            Intent intent = new Intent(activity_payment_confirmation.this, activity_live_tracking.class);
            startActivity(intent);
            finish();
        });
    }
}