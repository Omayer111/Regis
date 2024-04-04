plugins {
    alias(libs.plugins.androidApplication)
    id("com.google.gms.google-services")
}
buildscript {
    repositories {
        google() // Make sure to include Google's Maven repository
        // other repositories as needed
    }
    dependencies {
        // Add the Google Services Gradle plugin dependency
        classpath(libs.google.services)
    }
}

android {
    namespace = "com.example.regis"
    compileSdk = 34

    viewBinding {
        enable = true
    }
    buildFeatures {
        dataBinding = true
    }

    defaultConfig {
        applicationId = "com.example.regis"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.firebase.auth)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation(platform("com.google.firebase:firebase-bom:32.8.0"))
    implementation("com.google.firebase:firebase-auth")
}