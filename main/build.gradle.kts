plugins {
    id("com.android.library")
    kotlin("android")
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
}

android {
    compileSdk = 34
    namespace = "com.audkrs.emptyandroid.main"
    defaultConfig {
        minSdk = 21
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
}

kotlin {
    target.compilations.all {
        kotlinOptions {
            jvmTarget = "17"
        }
    }
}

dependencies {
    val composeBom = platform("androidx.compose:compose-bom:2023.08.00")

    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.0.3")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    implementation("androidx.annotation:annotation:1.6.0")
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("com.google.dagger:hilt-android:2.48")
    ksp("com.google.dagger:hilt-android-compiler:2.48")

    //Compose
    implementation(composeBom)
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")
    implementation("androidx.compose.material:material-icons-core")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")
}
