package com.example.rahban3;

import android.app.Activity;
import android.content.Intent;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DriverBottomNavHelper {

    public static void setup(
            Activity activity,
            BottomNavigationView bottomNavigationView,

            Class<?> homeActivity,
            Class<?> studentActivity,
            Class<?> notifActivity,
            Class<?> profileActivity

    ) {

        bottomNavigationView.setOnItemSelectedListener(item -> {

            int id = item.getItemId();

            // home
            if (id == R.id.driver_nav_home) {

                if (activity.getClass() != homeActivity) {
                    activity.startActivity(
                            new Intent(activity, homeActivity)
                    );
                    activity.finish();
                }

                return true;
            }

            // student
            if (id == R.id.driver_nav_students) {

                if (activity.getClass() != studentActivity) {
                    activity.startActivity(
                            new Intent(activity, studentActivity)
                    );

                }

                return true;
            }

            // notif
            if (id == R.id.driver_nav_services) {

                if (activity.getClass() != notifActivity) {
                    activity.startActivity(
                            new Intent(activity, notifActivity)
                    );

                }

                return true;
            }

            // prof
            if (id == R.id.driver_nav_profile) {

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