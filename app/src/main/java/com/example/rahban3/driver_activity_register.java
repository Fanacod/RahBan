package com.example.rahban3;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class driver_activity_register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.BLACK);
        setContentView(R.layout.activity_driver_register);

        Button btnRegisterDriver = findViewById(R.id.btnRegisterDriver);
        btnRegisterDriver.setOnClickListener(v -> {
            EditText edtFullName = findViewById(R.id.edtFullName);
            EditText edtNationalId = findViewById(R.id.edtNationalId);
            EditText edtMobile = findViewById(R.id.edtMobile);
            EditText edtLicense = findViewById(R.id.edtLicense);
            EditText edtExperience = findViewById(R.id.edtExperience);
            EditText edtEmergency = findViewById(R.id.edtEmergency);
            EditText edtVehicleType = findViewById(R.id.edtVehicleType);
            EditText edtVehicleModel = findViewById(R.id.edtVehicleModel);
            EditText edtVehicleColor = findViewById(R.id.edtVehicleColor);
            EditText edtPlate = findViewById(R.id.edtPlate);
            EditText edtCapacity = findViewById(R.id.edtCapacity);
            EditText edtArea = findViewById(R.id.edtArea);
            EditText edtRoute = findViewById(R.id.edtRoute);

            String fullName = edtFullName.getText().toString().trim();
            String nationalId = edtNationalId.getText().toString().trim();
            String mobile = edtMobile.getText().toString().trim();
            String license = edtLicense.getText().toString().trim();
            String experience = edtExperience.getText().toString().trim();
            String emergency = edtEmergency.getText().toString().trim();
            String vehicleType = edtVehicleType.getText().toString().trim();
            String vehicleModel = edtVehicleModel.getText().toString().trim();
            String vehicleColor = edtVehicleColor.getText().toString().trim();
            String plate = edtPlate.getText().toString().trim();
            String capacity = edtCapacity.getText().toString().trim();
            String area = edtArea.getText().toString().trim();
            String route = edtRoute.getText().toString().trim();

            new Thread(() -> {
                try {
                    URL url = new URL("https://nemayab.ir/rahban/api/add_drivers.php");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setDoOutput(true);
                    conn.setConnectTimeout(15000);
                    conn.setReadTimeout(15000);
                    conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

                    StringBuilder postData = new StringBuilder();
                    postData.append("full_name=").append(URLEncoder.encode(fullName, "UTF-8"));
                    postData.append("&mobile=").append(URLEncoder.encode(mobile, "UTF-8"));
                    postData.append("&national_id=").append(URLEncoder.encode(nationalId, "UTF-8"));
                    postData.append("&license_number=").append(URLEncoder.encode(license, "UTF-8"));
                    postData.append("&experience_years=").append(URLEncoder.encode(experience, "UTF-8"));
                    postData.append("&emergency_contact=").append(URLEncoder.encode(emergency, "UTF-8"));
                    postData.append("&vehicle_type=").append(URLEncoder.encode(vehicleType, "UTF-8"));
                    postData.append("&vehicle_model=").append(URLEncoder.encode(vehicleModel, "UTF-8"));
                    postData.append("&vehicle_color=").append(URLEncoder.encode(vehicleColor, "UTF-8"));
                    postData.append("&vehicle_plate=").append(URLEncoder.encode(plate, "UTF-8"));
                    postData.append("&vehicle_capacity=").append(URLEncoder.encode(capacity, "UTF-8"));
                    postData.append("&service_area=").append(URLEncoder.encode(area, "UTF-8"));
                    postData.append("&service_route=").append(URLEncoder.encode(route, "UTF-8"));

                    OutputStream os = conn.getOutputStream();
                    os.write(postData.toString().getBytes("UTF-8"));
                    os.flush();
                    os.close();

                    int responseCode = conn.getResponseCode();

                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(
                                    responseCode >= 200 && responseCode < 300
                                            ? conn.getInputStream()
                                            : conn.getErrorStream(),
                                    "UTF-8"
                            )
                    );

                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    reader.close();

                    runOnUiThread(() -> {
                        if (responseCode >= 200 && responseCode < 300
                                && response.toString().contains("\"result\":\"ok\"")) {
                            Intent intent = new Intent(driver_activity_register.this, driver_activity_home.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(driver_activity_register.this,
                                    "ثبت نام انجام نشد", Toast.LENGTH_LONG).show();
                        }
                    });
                } catch (Exception e) {
                    runOnUiThread(() -> Toast.makeText(driver_activity_register.this,
                            "خطا در ارتباط با سرور", Toast.LENGTH_LONG).show());
                }
            }).start();
        });
    }
}