plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdkVersion(29)
    defaultConfig {
        applicationId = "com.audkrs.emptyandroid"
        minSdkVersion(21)
        targetSdkVersion(29)
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":main"))
    implementation(kotlin("stdlib"))
    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}")
    implementation("androidx.annotation:annotation:1.1.0")
    implementation("com.google.android.material:material:1.1.0")
    implementation("androidx.recyclerview:recyclerview:1.1.0")
    implementation("androidx.core:core-ktx:1.3.0")
    implementation ("androidx.fragment:fragment-ktx:1.2.5")
    implementation("com.google.dagger:hilt-android:${Versions.dagger_hilt}")
    kapt ("com.google.dagger:hilt-android-compiler:${Versions.dagger_hilt}")

    testImplementation("androidx.test:core:1.2.0")
    testImplementation("androidx.test:runner:1.2.0")
    testImplementation("androidx.test:rules:1.2.0")
    testImplementation("androidx.test.ext:junit:1.1.1")
    testImplementation("androidx.test.ext:truth:1.2.0")
    testImplementation("com.google.truth:truth:1.0.1")
    testImplementation("androidx.test.espresso:espresso-core:3.2.0")
    testImplementation("org.robolectric:robolectric:4.3.1")
    testImplementation ("com.google.dagger:hilt-android-testing:${Versions.dagger_hilt}")
    kaptTest("com.google.dagger:hilt-android-compiler:${Versions.dagger_hilt}")

    androidTestImplementation("androidx.test:core:1.2.0")
    androidTestImplementation("androidx.test:runner:1.2.0")
    androidTestImplementation("androidx.test:rules:1.2.0")
    androidTestImplementation("androidx.test.ext:junit:1.1.1")
    androidTestImplementation("androidx.test.ext:truth:1.2.0")
    androidTestImplementation("com.google.truth:truth:1.0.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")
    androidTestImplementation ("com.google.dagger:hilt-android-testing:${Versions.dagger_hilt}")
    kaptAndroidTest("com.google.dagger:hilt-android-compiler:${Versions.dagger_hilt}")
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

