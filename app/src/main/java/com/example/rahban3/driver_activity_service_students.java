package com.example.rahban3;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rahban3.Adapter.DriverStudentAdapter;
import com.example.rahban3.Model.DriverStudent;
import com.example.rahban3.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class driver_activity_service_students extends AppCompatActivity {

    private RecyclerView recyclerStudents;
    private DriverStudentAdapter adapter;

    private ArrayList<DriverStudent> allStudents;
    private ArrayList<DriverStudent> filteredStudents;

    private TextView tabMorning;
    private TextView tabEvening;
    private TextView txtSectionTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setStatusBarColor(Color.WHITE);



        setContentView(R.layout.activity_driver_service_students);

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


        tabMorning = findViewById(R.id.tabMorning);
        tabEvening = findViewById(R.id.tabEvening);
        txtSectionTitle = findViewById(R.id.txtSectionTitle);

        recyclerStudents = findViewById(R.id.recyclerStudents);

        recyclerStudents.setLayoutManager(
                new LinearLayoutManager(this)
        );

        createStudents();

        showMorningStudents();

        tabMorning.setOnClickListener(v ->
                showMorningStudents()
        );

        tabEvening.setOnClickListener(v ->
                showEveningStudents()
        );
    }

    private void createStudents() {

        allStudents = new ArrayList<>();

        // صبح
        allStudents.add(
                new DriverStudent(
                        "سارا احمدی",
                        "پایه هفتم",
                        "دبیرستان فرزانگان",
                        "منطقه ۶، خیابان ولیعصر",
                        "0912••••123",
                        "منزل ← مدرسه",

                        true
                )
        );

        allStudents.add(
                new DriverStudent(
                        "محمد رضایی",
                        "پایه پنجم",
                        "دبستان فرزانگان",
                        "منطقه ۶، خیابان انقلاب",
                        "0912••••456",
                        "منزل ← مدرسه",

                        true
                )
        );

        allStudents.add(
                new DriverStudent(
                        "آرین محمدی",
                        "پایه ششم",
                        "دبستان فرزانگان",
                        "منطقه ۵، میدان ونک",
                        "0910••••789",
                        "منزل ← مدرسه",

                        true
                )
        );


        // عصر
        allStudents.add(
                new DriverStudent(
                        "سارا احمدی",
                        "پایه هفتم",
                        "دبیرستان فرزانگان",
                        "منطقه ۶، خیابان ولیعصر",
                        "0912••••123",
                        "مدرسه ← منزل",

                        false
                )
        );

        allStudents.add(
                new DriverStudent(
                        "محمد رضایی",
                        "پایه پنجم",
                        "دبستان فرزانگان",
                        "منطقه ۶، خیابان انقلاب",
                        "0912••••456",
                        "مدرسه ← منزل",

                        false
                )
        );
    }


    private void showMorningStudents() {

        filteredStudents = new ArrayList<>();

        for (DriverStudent student : allStudents) {

            if (student.isMorning()) {
                filteredStudents.add(student);
            }
        }

        adapter = new DriverStudentAdapter(filteredStudents);

        recyclerStudents.setAdapter(adapter);

        tabMorning.setBackgroundResource(
                R.drawable.bg_tab_selected
        );

        tabMorning.setTextColor(Color.WHITE);

        tabEvening.setBackgroundResource(0);

        tabEvening.setTextColor(
                Color.parseColor("#52717A")
        );

        txtSectionTitle.setText(
                "دانش‌آموزان نوبت صبح"
        );
    }


    private void showEveningStudents() {

        filteredStudents = new ArrayList<>();

        for (DriverStudent student : allStudents) {

            if (!student.isMorning()) {
                filteredStudents.add(student);
            }
        }

        adapter = new DriverStudentAdapter(filteredStudents);

        recyclerStudents.setAdapter(adapter);

        tabEvening.setBackgroundResource(
                R.drawable.bg_tab_selected
        );

        tabEvening.setTextColor(Color.WHITE);

        tabMorning.setBackgroundResource(0);

        tabMorning.setTextColor(
                Color.parseColor("#52717A")
        );

        txtSectionTitle.setText(
                "دانش‌آموزان نوبت عصر"
        );
    }
}