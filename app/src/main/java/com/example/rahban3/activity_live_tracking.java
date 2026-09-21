package com.example.rahban3;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class activity_live_tracking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setStatusBarColor(Color.BLACK);

        setContentView(R.layout.activity_live_tracking);

        // اطلاعات نمونه
        TextView txtDriverName = findViewById(R.id.txtDriverName);
        TextView txtServiceNumber = findViewById(R.id.txtServiceNumber);
        TextView txtSchool = findViewById(R.id.txtSchool);
        TextView txtEta = findViewById(R.id.txtEta);

        txtDriverName.setText("مهدی رضایی");
        txtServiceNumber.setText("سرویس شماره ۱۲");
        txtSchool.setText("مدرسه");
        txtEta.setText("ETA: ۷ دقیقه");
    }
}