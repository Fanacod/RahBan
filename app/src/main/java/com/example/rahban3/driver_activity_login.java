package com.example.rahban3;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class driver_activity_login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.WHITE);

        setContentView(R.layout.activity_driver_login);
        ConstraintLayout otpOverlay = findViewById(R.id.otpOverlay );
        Button btnGetCode = findViewById(R.id.btnGetCode);
        Button btnVerify = findViewById(R.id.btnVerify);

        btnGetCode.setOnClickListener(v ->{
            otpOverlay.setVisibility(View.VISIBLE);
        } );

        btnVerify.setOnClickListener(v->{
            Intent intent = new Intent(driver_activity_login.this, driver_activity_register.class);
            startActivity(intent);
            finish();
        });

    }
}