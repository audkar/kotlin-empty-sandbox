plugins {
    id("com.android.library")
    kotlin("android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = 33
    defaultConfig {
        minSdk = 21
        targetSdk = 33
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        viewBinding = true
    }
}

kotlin {
    target.compilations.all {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
}

dependencies {
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.1.8")
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
    implementation("androidx.annotation:annotation:1.4.0")
    implementation("com.google.android.material:material:1.6.1")
    implementation("androidx.core:core-ktx:1.8.0")
    implementation("androidx.fragment:fragment-ktx:1.5.2")
    implementation("com.google.dagger:hilt-android:2.43.2")
    kapt("com.google.dagger:hilt-android-compiler:2.43.2")
}
