package com.example.rahban3;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rahban3.Adapter.ServiceAdapter;
import com.example.rahban3.Model.Service;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class activity_school_services extends AppCompatActivity {

    RecyclerView recyclerServices;
    ServiceAdapter serviceAdapter;
    ArrayList<Service> serviceList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setStatusBarColor(Color.BLACK);

        setContentView(R.layout.activity_school_services);

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

        // school name
        TextView txtSchoolName = findViewById(R.id.txtSchoolName);

        String schoolName =
                getIntent().getStringExtra("school_name");

        if (schoolName != null) {
            txtSchoolName.setText(schoolName);
        }

        //back btn
        ImageView btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(v -> finish());

        // RecyclerView
        recyclerServices = findViewById(R.id.recyclerServices);

        recyclerServices.setLayoutManager(
                new LinearLayoutManager(this)
        );

        // list
        serviceList = new ArrayList<>();

        serviceList.add(
                new Service(
                        "مهدی رضایی",
                        "سرویس شماره ۱۲",
                        "4.8",
                        "۱۴ نفر",
                        "منطقه ۶ → مدرسه",
                        true
                )
        );

        serviceList.add(
                new Service(
                        "حسین احمدی",
                        "سرویس شماره ۱۸",
                        "4.6",
                        "۱۲ نفر",
                        "منطقه ۵ → مدرسه",
                        true
                )
        );

        serviceList.add(
                new Service(
                        "علی محمدی",
                        "سرویس شماره ۲۱",
                        "4.7",
                        "۱۰ نفر",
                        "منطقه ۴ → مدرسه",
                        true
                )
        );

        // Adapter
        serviceAdapter = new ServiceAdapter(serviceList);

        recyclerServices.setAdapter(serviceAdapter);
    }
}