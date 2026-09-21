package com.example.rahban3;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


public class activity_login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.BLACK);

        setContentView(R.layout.activity_login);

        ConstraintLayout otpOverlay = findViewById(R.id.otpOverlay );
        Button btnGetCode = findViewById(R.id.btnGetCode);
        Button btnVerify = findViewById(R.id.btnVerify);

        btnGetCode.setOnClickListener(v ->{
            otpOverlay.setVisibility(View.VISIBLE);
        } );

        btnVerify.setOnClickListener(v->{
            Intent intent = new Intent(activity_login.this, activity_complate_parent_information.class);
            startActivity(intent);
            finish();
        });
    }
}