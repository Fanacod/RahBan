package com.example.rahban3;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rahban3.Adapter.DriverNotificationAdapter;
import com.example.rahban3.Model.DriverNotification;
import com.example.rahban3.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class driver_activity_notifications extends AppCompatActivity {

    private RecyclerView recyclerNotifications;

    private DriverNotificationAdapter adapter;

    private ArrayList<DriverNotification> notificationList;

    private TextView txtUnreadCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setStatusBarColor(Color.WHITE);
        setContentView(R.layout.activity_driver_notifications);

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


        // RecyclerView
        recyclerNotifications =
                findViewById(R.id.recyclerNotifications);

        recyclerNotifications.setLayoutManager(
                new LinearLayoutManager(this)
        );


        // Texts
        txtUnreadCount =
                findViewById(R.id.txtUnreadCount);




        // Create notifications
        createNotifications();


        // Adapter
        adapter =
                new DriverNotificationAdapter(
                        notificationList
                );

        recyclerNotifications.setAdapter(adapter);


        updateUnreadCount();



    }


    private void createNotifications() {

        notificationList =
                new ArrayList<>();


        notificationList.add(
                new DriverNotification(
                        "درخواست جدید سرویس",
                        "درخواست سرویس جدیدی از طرف والد ثبت شده است.",
                        "۱۰ دقیقه پیش",
                        "درخواست سرویس",
                        true
                )
        );


        notificationList.add(
                new DriverNotification(
                        "درخواست سرویس تأیید شد",
                        "درخواست سارا احمدی با موفقیت به سرویس شما اضافه شد.",
                        "۳۵ دقیقه پیش",
                        "سرویس",
                        true
                )
        );


        notificationList.add(
                new DriverNotification(
                        "یادآوری سفر صبح",
                        "سفر صبح سرویس شماره ۱۲ ساعت ۰۷:۰۰ آغاز می‌شود.",
                        "۱ ساعت پیش",
                        "یادآوری",
                        true
                )
        );


        notificationList.add(
                new DriverNotification(
                        "اطلاعات سرویس به‌روزرسانی شد",
                        "اطلاعات سرویس شما با موفقیت به‌روزرسانی شد.",
                        "امروز",
                        "سیستم",
                        false
                )
        );


        notificationList.add(
                new DriverNotification(
                        "دانش‌آموز جدید",
                        "محمد رضایی به لیست دانش‌آموزان سرویس اضافه شد.",
                        "دیروز",
                        "دانش‌آموز",
                        false
                )
        );


        notificationList.add(
                new DriverNotification(
                        "یادآوری سفر عصر",
                        "سفر عصر امروز ساعت ۱۳:۳۰ انجام می‌شود.",
                        "دیروز",
                        "یادآوری",
                        false
                )
        );
    }


    private void updateUnreadCount() {

        int count =
                adapter.getUnreadCount();

        if (count == 0) {

            txtUnreadCount.setText(
                    "همه اعلان‌ها خوانده شده‌اند"
            );

        } else {

            txtUnreadCount.setText(
                    count + " اعلان خوانده نشده"
            );
        }
    }
}