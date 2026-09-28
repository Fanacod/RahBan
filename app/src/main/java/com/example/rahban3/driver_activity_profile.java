package com.example.rahban3;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.card.MaterialCardView;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

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

        Button btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(v -> {
            getSharedPreferences("rahban", MODE_PRIVATE)
                    .edit()
                    .clear()
                    .apply();

            Intent intent = new Intent(driver_activity_profile.this, driver_activity_splash.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        });

        TextView txtDriverName = findViewById(R.id.txtDriverName);
        TextView txtProfileName = findViewById(R.id.txtProfileName);
        TextView txtProfileMobile = findViewById(R.id.txtProfileMobile);
        TextView txtProfileNationalId = findViewById(R.id.txtProfileNationalId);
        TextView txtVehicle = findViewById(R.id.txtVehicle);
        TextView txtVehiclePlate = findViewById(R.id.txtVehiclePlate);
        TextView txtVehicleCapacity = findViewById(R.id.txtVehicleCapacity);
        ImageView imgVerifiedTick = findViewById(R.id.imgVerifiedTick);

        LinearLayout verifiedBadge = findViewById(R.id.verifiedBadge);
        TextView txtVerifiedText = findViewById(R.id.txtVerifiedText);
        TextView txtServiceSectionTitle = findViewById(R.id.txtServiceSectionTitle);
        MaterialCardView cardActiveService = findViewById(R.id.cardActiveService);

        String driverId = getSharedPreferences("rahban", MODE_PRIVATE)
                .getString("driver_id", "");

        new Thread(() -> {
            try {
                URL url = new URL("https://nemayab.ir/rahban/api/get_drivers.php?driver_id=" + driverId);
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

                if (!"ok".equals(json.getString("result"))) {
                    return;
                }

                JSONObject driver = json.getJSONObject("driver");

                String fullName = driver.optString("full_name", "");
                String mobile = driver.optString("mobile", "");
                String nationalId = driver.optString("national_id", "");
                String vehicleType = driver.optString("vehicle_type", "");
                String vehicleModel = driver.optString("vehicle_model", "");
                String vehiclePlate = driver.optString("vehicle_plate", "");
                String vehicleCapacity = driver.optString("vehicle_capacity", "");
                String status = driver.optString("status", "pending");

                runOnUiThread(() -> {
                    txtDriverName.setText(fullName);
                    txtProfileName.setText(fullName);
                    txtProfileMobile.setText(mobile);
                    txtProfileNationalId.setText(nationalId);

                    String vehicle = (vehicleType + " " + vehicleModel).trim();
                    txtVehicle.setText(vehicle.isEmpty() ? "-" : vehicle);

                    txtVehiclePlate.setText(vehiclePlate.isEmpty() ? "-" : vehiclePlate);

                    txtVehicleCapacity.setText(
                            vehicleCapacity.isEmpty() ? "-" : vehicleCapacity + " دانش‌آموز"
                    );

                    if ("active".equals(status)) {
                        verifiedBadge.setVisibility(View.VISIBLE);
                        verifiedBadge.setBackgroundResource(R.drawable.bg_bus_icon);
                        imgVerifiedTick.setVisibility(View.VISIBLE);
                        txtVerifiedText.setText("حساب تأیید شده");
                        txtVerifiedText.setTextColor(0xFF0FA69A);
                    } else {
                        verifiedBadge.setVisibility(View.VISIBLE);
                        verifiedBadge.setBackgroundResource(R.drawable.bg_pending_badge);
                        imgVerifiedTick.setVisibility(View.GONE);
                        txtVerifiedText.setText("در حال بررسی");
                        txtVerifiedText.setTextColor(0xFFCC0136);
                    }

                    txtServiceSectionTitle.setVisibility(View.GONE);
                    cardActiveService.setVisibility(View.GONE);
                });

            } catch (Exception e) {
                runOnUiThread(() -> {
                    txtServiceSectionTitle.setVisibility(View.GONE);
                    cardActiveService.setVisibility(View.GONE);
                });
            }
        }).start();

    }
}