package com.example.rahban3;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rahban3.Adapter.SchoolAdapter;
import com.example.rahban3.Model.School;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class activity_search_school extends AppCompatActivity {
    RecyclerView recyclerSchools;
    SchoolAdapter schoolAdapter;
    ArrayList<School> schoolList;
    EditText edtSearchSchool;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.BLACK);

        setContentView(R.layout.activity_search_school);

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


        //btn back
        ImageView btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(activity_search_school.this, MainActivity.class);
            startActivity(intent);
        });

        //-----
        // Request add school
        Button btnRequestSchool =
                findViewById(R.id.btnRequestSchool);

        btnRequestSchool.setOnClickListener(v -> {

            Intent intent = new Intent(activity_search_school.this, RequestAddSchool.class);
            startActivity(intent);
        });
        // -------------------------
        // Search Box
        // -------------------------

        edtSearchSchool = findViewById(R.id.edtSearchSchool);

        //------
        // RecyclerView
        //-----
        recyclerSchools = findViewById(R.id.recyclerSchools);

        recyclerSchools.setLayoutManager(
                new LinearLayoutManager(this)
        );
        schoolList = new ArrayList<>();

        schoolList.add(new School("دبستان و دبیرستان فرزانگان", "منطقه ۶ • تهران"));

        schoolList.add(new School("دبیرستان دخترانه مهر", "منطقه ۲ • تهران"));

        schoolList.add(new School("دبیرستان علامه حلی", "منطقه ۱ • تهران"));


        // Adapter
        schoolAdapter = new SchoolAdapter(schoolList, school -> {

            Intent intent = new Intent(
                    activity_search_school.this,
                    activity_school_services.class
            );

            intent.putExtra("school_name", school.getName());

            startActivity(intent);
        });

        recyclerSchools.setAdapter(schoolAdapter);


        //live search
        edtSearchSchool.addTextChangedListener(
                new TextWatcher() {

                    @Override
                    public void beforeTextChanged(
                            CharSequence s,
                            int start,
                            int count,
                            int after) {
                    }

                    @Override
                    public void onTextChanged(
                            CharSequence s,
                            int start,
                            int before,
                            int count) {

                        schoolAdapter.filter(
                                s.toString()
                        );
                    }

                    @Override
                    public void afterTextChanged(
                            Editable s) {
                    }
                }
        );

    }
}