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

public class driver_activity_register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.BLACK);
        setContentView(R.layout.activity_driver_register);

        Button btnRegisterDriver = findViewById(R.id.btnRegisterDriver);
        btnRegisterDriver.setOnClickListener(v->{
            Intent intent = new Intent(driver_activity_register.this, driver_activity_home.class);
            startActivity(intent);
            finish();
        });
    }
}