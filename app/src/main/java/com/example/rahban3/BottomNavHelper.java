package com.example.rahban3;

import android.app.Activity;
import android.content.Intent;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNavHelper {

    public static void setup(
            Activity activity,
            BottomNavigationView bottomNavigationView,

            Class<?> homeActivity,
            Class<?> mapActivity,
            Class<?> tripsActivity,
            Class<?> profileActivity

    ) {

        bottomNavigationView.setOnItemSelectedListener(item -> {

            int id = item.getItemId();

            // home
            if (id == R.id.nav_home) {

                if (activity.getClass() != homeActivity) {
                    activity.startActivity(
                            new Intent(activity, homeActivity)
                    );

                }

                return true;
            }

            // map
            if (id == R.id.nav_map) {

                if (activity.getClass() != mapActivity) {
                    activity.startActivity(
                            new Intent(activity, mapActivity)
                    );

                }

                return true;
            }

            // trips
            if (id == R.id.nav_trips) {

                if (activity.getClass() != tripsActivity) {
                    activity.startActivity(
                            new Intent(activity, tripsActivity)
                    );

                }

                return true;
            }

            // prof
            if (id == R.id.nav_profile) {

                if (activity.getClass() != profileActivity) {
                    activity.startActivity(
                            new Intent(activity, profileActivity)
                    );

                }

                return true;
            }

            return false;
        });
    }
}