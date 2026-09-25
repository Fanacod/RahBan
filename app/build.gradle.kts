plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.rahban3"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.example.rahban3"
        minSdk = 23
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = false
            }
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.activity.ktx)
    implementation(libs.appcompat)
    implementation(libs.constraintlayout)
    implementation(libs.material)

    // SDK نقشه نشان (MapLibre OpenGL)
    implementation("org.neshan.maplibre:android-sdk-opengl:13.4.1")

    // کتابخانه‌های استاندارد اندروید
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.2.0")
    implementation("com.google.android.gms:play-services-location:21.0.1")

    testImplementation(libs.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(libs.ext.junit)
}
