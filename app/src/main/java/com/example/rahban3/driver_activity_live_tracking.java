package com.example.rahban3;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.provider.Settings;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.Priority;

import org.maplibre.android.MapLibre;
import org.maplibre.android.annotations.Marker;
import org.maplibre.android.annotations.MarkerOptions;
import org.maplibre.android.camera.CameraPosition;
import org.maplibre.android.camera.CameraUpdateFactory;
import org.maplibre.android.geometry.LatLng;
import org.maplibre.android.maps.MapLibreMap;
import org.maplibre.android.maps.MapView;
import org.maplibre.android.maps.Style;

public class driver_activity_live_tracking extends AppCompatActivity implements LocationListener {

    private MapView mapView;
    private MapLibreMap neshanMap;
    private FusedLocationProviderClient fusedLocationClient;
    private LocationCallback locationCallback;
    private LocationManager locationManager;
    private Marker driverMarker;
    private boolean isFirstZoomDone = false;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MapLibre.getInstance(this);
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.WHITE);
        setContentView(R.layout.activity_driver_live_tracking);

        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        // آماده‌سازی کالبک گوگل
        setupGoogleLocationCallback();

        mapView.getMapAsync(map -> {
            neshanMap = map;
            neshanMap.setStyle(new Style.Builder().fromUri("https://static.neshan.org/sdk/maplibre/styles/light.json"), new Style.OnStyleLoaded() {
                @Override
                public void onStyleLoaded(@NonNull Style style) {
                    checkAndRequestPermissions();
                }
            });
        });
    }

    private void setupGoogleLocationCallback() {
        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(@NonNull LocationResult locationResult) {
                if (locationResult == null) return;
                for (Location location : locationResult.getLocations()) {
                    if (location != null) {
                        updateDriverOnMap(location);
                    }
                }
            }
        };
    }

    private void checkAndRequestPermissions() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                    LOCATION_PERMISSION_REQUEST_CODE);
        } else {
            verifyGpsEnabledAndStart();
        }
    }

    private void verifyGpsEnabledAndStart() {
        boolean isGpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        boolean isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

        if (!isGpsEnabled && !isNetworkEnabled) {
            Toast.makeText(this, "لطفاً GPS گوشی را روشن کنید", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivity(intent);
            return;
        }

        startDualLocationTracking();
    }

    private void startDualLocationTracking() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        Toast.makeText(this, "در حال جستجوی موقعیت ماهواره‌ای...", Toast.LENGTH_SHORT).show();

        // روش اول: آخرین لوکیشن سریع
        fusedLocationClient.getLastLocation().addOnSuccessListener(this, location -> {
            if (location != null) {
                updateDriverOnMap(location);
            }
        });

        // روش دوم: آپدیت زنده Fused Location
        LocationRequest locationRequest = new LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, 2000)
                .setMinUpdateIntervalMillis(1000)
                .build();
        fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, Looper.getMainLooper());

        // روش سوم (ویژه شیائومی و قطعی‌های داخلی): LocationManager مستقیم اندروید
        try {
            if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 1f, this);
            }
            if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1f, this);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateDriverOnMap(Location location) {
        if (neshanMap == null || location == null) return;

        LatLng currentPos = new LatLng(location.getLatitude(), location.getLongitude());

        // قرار دادن یا جابه‌جایی مارکر
        if (driverMarker == null) {
            driverMarker = neshanMap.addMarker(new MarkerOptions()
                    .position(currentPos)
                    .title("موقعیت راننده"));
        } else {
            driverMarker.setPosition(currentPos);
        }

        // بار اول نرم زوم کنه روی راننده
        if (!isFirstZoomDone) {
            CameraPosition cameraPosition = new CameraPosition.Builder()
                    .target(currentPos)
                    .zoom(16.5)
                    .build();
            neshanMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition), 1200);
            isFirstZoomDone = true;
            Toast.makeText(this, "موقعیت شما دریافت شد!", Toast.LENGTH_SHORT).show();
        }
    }

    // کالبک LocationListener اندروید
    @Override
    public void onLocationChanged(@NonNull Location location) {
        updateDriverOnMap(location);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                verifyGpsEnabledAndStart();
            } else {
                Toast.makeText(this, "دسترسی لوکیشن داده نشد!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mapView != null) mapView.onPause();
        if (fusedLocationClient != null && locationCallback != null) {
            fusedLocationClient.removeLocationUpdates(locationCallback);
        }
        if (locationManager != null) {
            locationManager.removeUpdates(this);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mapView != null) mapView.onResume();
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            verifyGpsEnabledAndStart();
        }
    }

    // متدهای چرخه حیات
    @Override protected void onStart() { super.onStart(); if (mapView != null) mapView.onStart(); }
    @Override protected void onStop() { super.onStop(); if (mapView != null) mapView.onStop(); }
    @Override protected void onDestroy() { super.onDestroy(); if (mapView != null) mapView.onDestroy(); }
    @Override public void onLowMemory() { super.onLowMemory(); if (mapView != null) mapView.onLowMemory(); }
    @Override protected void onSaveInstanceState(@NonNull Bundle outState) { super.onSaveInstanceState(outState); if (mapView != null) mapView.onSaveInstanceState(outState); }
}
