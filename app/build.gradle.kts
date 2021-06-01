plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdkVersion(30)
    defaultConfig {
        applicationId = "com.audkrs.emptyandroid"
        minSdkVersion(21)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "com.audkrs.emptyandroid.TestRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    testOptions {
        unitTests.isIncludeAndroidResources = true
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
    implementation(project(":main"))
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.1.5")
    implementation("androidx.appcompat:appcompat:1.3.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.3-native-mt")
    implementation("androidx.annotation:annotation:1.2.0")
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.recyclerview:recyclerview:1.2.0")
    implementation("androidx.core:core-ktx:1.3.2")
    implementation ("androidx.fragment:fragment-ktx:1.3.4")
    implementation("com.google.dagger:hilt-android:2.33-beta")
    kapt("com.google.dagger:hilt-android-compiler:2.33-beta")
    debugImplementation("com.squareup.leakcanary:leakcanary-android:2.7")

    testImplementation("androidx.test:core:1.3.0")
    testImplementation("androidx.test:runner:1.3.0")
    testImplementation("androidx.test:rules:1.3.0")
    testImplementation("androidx.test.ext:junit:1.1.2")
    testImplementation("androidx.test.ext:truth:1.3.0")
    testImplementation("com.google.truth:truth:1.1.3")
    testImplementation("androidx.test.espresso:espresso-core:3.3.0")
    testImplementation("org.robolectric:robolectric:4.5.1")
    testImplementation("com.google.dagger:hilt-android-testing:2.33-beta")
    kaptTest("com.google.dagger:hilt-android-compiler:2.33-beta")

    androidTestImplementation("androidx.test:core:1.3.0")
    androidTestImplementation("androidx.test:runner:1.3.0")
    androidTestImplementation("androidx.test:rules:1.3.0")
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.ext:truth:1.3.0")
    androidTestImplementation("com.google.truth:truth:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
    androidTestImplementation("com.google.dagger:hilt-android-testing:2.33-beta")
    kaptAndroidTest("com.google.dagger:hilt-android-compiler:2.33-beta")
}

configurations.all {
    resolutionStrategy.dependencySubstitution {
      substitute(module("junit:junit:4.12")).with(module("junit:junit:4.13"))
    }
}


kapt {
    correctErrorTypes = true
}

hilt {
    enableTransformForLocalTests = true
}
