plugins {
    id("com.android.library")
    kotlin("android")
    id("kotlin-android-extensions")
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}")
    implementation("androidx.annotation:annotation:1.1.0")
    implementation("com.google.android.material:material:1.2.1")
    implementation("androidx.core:core-ktx:1.3.2")
    implementation ("androidx.fragment:fragment-ktx:1.2.5")
    implementation("com.google.dagger:hilt-android:${Versions.dagger_hilt}")
    kapt ("com.google.dagger:hilt-android-compiler:${Versions.dagger_hilt}")
}
