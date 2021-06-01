plugins {
    id("com.android.library")
    kotlin("android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdkVersion(30)
    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(30)
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        viewBinding = true
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.3.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.3-native-mt")
    implementation("androidx.annotation:annotation:1.2.0")
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.core:core-ktx:1.5.0")
    implementation ("androidx.fragment:fragment-ktx:1.3.4")
    implementation("com.google.dagger:hilt-android:2.33-beta")
    kapt("com.google.dagger:hilt-android-compiler:2.33-beta")
}
