package com.example.rahban3;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rahban3.Adapter.DriverRequestAdapter;
import com.example.rahban3.Model.DriverRequest;
import com.example.rahban3.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class driver_activity_requests extends AppCompatActivity {

    private RecyclerView recyclerRequests;
    private DriverRequestAdapter adapter;
    private ArrayList<DriverRequest> requestList;

    private int capacity = 4;
    private int currentStudents = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setStatusBarColor(Color.WHITE);


        setContentView(R.layout.activity_driver_requests);
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

        ImageView btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(v -> finish());

        recyclerRequests = findViewById(R.id.recyclerRequests);

        recyclerRequests.setLayoutManager(
                new LinearLayoutManager(this)
        );

        createRequests();

        adapter = new DriverRequestAdapter(requestList);

        recyclerRequests.setAdapter(adapter);
    }

    private void createRequests() {

        requestList = new ArrayList<>();

        requestList.add(
                new DriverRequest(
                        "سارا احمدی",
                        "پایه هفتم",
                        "دبیرستان فرزانگان",
                        "منطقه ۶، خیابان ولیعصر",
                        "۰۷:۰۰ صبح",
                        "منزل ← مدرسه"
                )
        );

        requestList.add(
                new DriverRequest(
                        "محمد رضایی",
                        "پایه پنجم",
                        "دبستان فرزانگان",
                        "منطقه ۶، خیابان انقلاب",
                        "۰۷:۱۰ صبح",
                        "منزل ← مدرسه"
                )
        );
    }
}