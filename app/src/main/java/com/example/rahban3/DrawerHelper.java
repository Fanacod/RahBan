package com.example.rahban3;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.drawerlayout.widget.DrawerLayout;

public class DrawerHelper {

    public static void setup(Activity activity) {

        DrawerLayout drawerLayout =
                activity.findViewById(R.id.drawerLayout);

        ImageView btnMenu =
                activity.findViewById(R.id.btnMenu);

        if (drawerLayout == null) {
            return;
        }

        if (btnMenu == null) {
            return;
        }

        // باز کردن منو با دکمه
        btnMenu.setOnClickListener(v -> {
            drawerLayout.openDrawer(Gravity.RIGHT);
        });


        // پروفایل
        LinearLayout profile =
                activity.findViewById(R.id.drawerProfile);

        if (profile != null) {
            profile.setOnClickListener(v -> {

                drawerLayout.closeDrawer(Gravity.RIGHT);

                // بعداً صفحه پروفایل
            });
        }


        // اعلان‌ها
        LinearLayout notifications =
                activity.findViewById(R.id.drawerNotifications);

        if (notifications != null) {
            notifications.setOnClickListener(v -> {

                drawerLayout.closeDrawer(Gravity.RIGHT);

                // صفحه اعلان‌ها
            });
        }


        // تماس با پشتیبانی
        LinearLayout support =
                activity.findViewById(R.id.drawerSupport);

        if (support != null) {
            support.setOnClickListener(v -> {

                Intent intent =
                        new Intent(Intent.ACTION_DIAL);

                intent.setData(
                        Uri.parse("tel:02112345678")
                );

                activity.startActivity(intent);
            });
        }


        // اشتراک
        LinearLayout subscription =
                activity.findViewById(R.id.drawerSubscription);

        if (subscription != null) {
            subscription.setOnClickListener(v -> {

                drawerLayout.closeDrawer(Gravity.RIGHT);

                // صفحه اشتراک
            });
        }




        // خروج
        LinearLayout logout =
                activity.findViewById(R.id.drawerLogout);

        if (logout != null) {
            logout.setOnClickListener(v -> {

                drawerLayout.closeDrawer(Gravity.RIGHT);

                // خروج از حساب
            });
        }
    }
}