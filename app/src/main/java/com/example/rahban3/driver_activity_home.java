package com.example.rahban3;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.card.MaterialCardView;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class driver_activity_home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.WHITE);
        setContentView(R.layout.activity_driver_home);

        LinearLayout statusBadge = findViewById(R.id.statusBadge);
        View statusDot = findViewById(R.id.statusDot);
        TextView txtStatusBadge = findViewById(R.id.txtStatusBadge);
        TextView txtGreeting = findViewById(R.id.txtGreeting);

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

        LinearLayout activeServiceContent = findViewById(R.id.activeServiceContent);
        LinearLayout pendingContent = findViewById(R.id.pendingContent);

        MaterialCardView serviceCard = findViewById(R.id.serviceCard);
        TextView txtQuickAccessTitle = findViewById(R.id.txtQuickAccessTitle);
        LinearLayout quickAccessRow = findViewById(R.id.quickAccessRow);

        String driverId = getSharedPreferences("rahban", MODE_PRIVATE)
                .getString("driver_id", "");

        new Thread(() -> {
            try {
                URL url = new URL("https://nemayab.ir/rahban/api/get_drivers.php?id=" + driverId);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setConnectTimeout(15000);
                conn.setReadTimeout(15000);

                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(conn.getInputStream(), "UTF-8"));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                JSONObject json = new JSONObject(response.toString());
                String status = "pending";
                String driverName = "";

                if ("ok".equals(json.getString("result"))) {
                    JSONObject driver = json.getJSONObject("driver");
                    status = driver.getString("status");
                    driverName = driver.optString("full_name", "");
                }

                final String finalStatus = status;
                final String finalName = driverName;

                runOnUiThread(() -> {
                    if (!finalName.isEmpty()) {
                        txtGreeting.setText("صبح بخیر " + finalName);
                    }

                    if ("active".equals(finalStatus)) {
                        serviceCard.setVisibility(View.VISIBLE);
                        btnStartService.setVisibility(View.VISIBLE);
                        txtQuickAccessTitle.setVisibility(View.VISIBLE);
                        quickAccessRow.setVisibility(View.VISIBLE);
                        pendingContent.setVisibility(View.GONE);

                        statusBadge.setBackgroundResource(R.drawable.bg_online_status);
                        statusDot.setBackgroundResource(R.drawable.bg_status_dot);
                        txtStatusBadge.setText("آنلاین");
                        txtStatusBadge.setTextColor(0xFF168B7F);
                    } else {
                        serviceCard.setVisibility(View.GONE);
                        btnStartService.setVisibility(View.GONE);
                        txtQuickAccessTitle.setVisibility(View.GONE);
                        quickAccessRow.setVisibility(View.GONE);
                        pendingContent.setVisibility(View.VISIBLE);

                        statusBadge.setBackgroundResource(R.drawable.bg_confirmed_badge);
                        statusDot.setBackgroundResource(R.drawable.bg_status_dot);
                        txtStatusBadge.setText("در حال پردازش");
                        txtStatusBadge.setTextColor(0xFFCC0136);
                    }
                });
            } catch (Exception e) {
                runOnUiThread(() -> {
                    serviceCard.setVisibility(View.GONE);
                    btnStartService.setVisibility(View.GONE);
                    txtQuickAccessTitle.setVisibility(View.GONE);
                    quickAccessRow.setVisibility(View.GONE);
                    pendingContent.setVisibility(View.VISIBLE);

                    statusBadge.setBackgroundResource(R.drawable.bg_confirmed_badge);
                    statusDot.setBackgroundResource(R.drawable.bg_status_dot);
                    txtStatusBadge.setText("در حال پردازش");
                    txtStatusBadge.setTextColor(0xFFCC0136);
                });
            }
        }).start();

    }
}