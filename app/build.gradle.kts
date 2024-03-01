plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-parcelize")
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
}

android {
    compileSdk = 34
    namespace = "com.audkrs.emptyandroid"
    defaultConfig {
        applicationId = "com.audkrs.emptyandroid"
        minSdk = 21
        //noinspection ExpiredTargetSdkVersion
        targetSdk = 31
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
        managedDevices {
            devices {
                maybeCreate<com.android.build.api.dsl.ManagedVirtualDevice>("pixel2api30").apply {
                    device = "Pixel 2"
                    apiLevel = 30
                    require64Bit = true
                    systemImageSource = "aosp-atd"
                }
            }
        }
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.androidx.compose.compiler.get().version
    }
}

dependencies {
    implementation(project(":main"))
    coreLibraryDesugaring(libs.com.android.tools.desugar.jdk.libs)
    implementation(libs.androidx.appcompat)
    implementation(libs.org.jetbrains.kotlinx.kotlinx.coroutines.android)
    implementation(libs.androidx.annotation)
    implementation(libs.androidx.core.core.ktx)
    implementation(libs.androidx.activity.activity.ktx)
    implementation(libs.com.google.dagger.hilt.android)
    ksp(libs.com.google.dagger.hilt.android.compiler)
    debugImplementation(libs.com.squareup.leakcanary.leakcanary.android)
    //Compose
    implementation(platform(libs.androidx.compose.compose.bom))
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui.ui.tooling.preview)
    debugImplementation(libs.androidx.compose.ui.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.ui.test.manifest)
    implementation(libs.androidx.compose.material.material.icons.core)
    implementation(libs.androidx.activity.activity.compose)
    implementation(libs.androidx.lifecycle.lifecycle.viewmodel.compose)
    implementation(libs.org.jetbrains.kotlinx.kotlinx.collections.immutable)
    lintChecks(libs.com.slack.lint.compose.compose.lint.checks)

    testImplementation(libs.junit)
    testImplementation(libs.androidx.test.ext.truth)
    testImplementation(libs.com.google.truth)
    testImplementation(libs.org.robolectric)
    testImplementation(libs.com.google.dagger.hilt.android.testing)
    kspTest(libs.com.google.dagger.hilt.android.compiler)
    testImplementation(platform(libs.androidx.compose.compose.bom))
    testImplementation(libs.androidx.compose.ui.ui.test.junit4)

    androidTestImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.core)
    androidTestImplementation(libs.androidx.test.runner)
    androidTestImplementation(libs.androidx.test.rules)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.androidx.test.ext.truth)
    androidTestImplementation(libs.com.google.truth)
    androidTestImplementation(libs.com.google.dagger.hilt.android.testing)
    kspAndroidTest(libs.com.google.dagger.hilt.android.compiler)
    androidTestImplementation(platform(libs.androidx.compose.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.ui.test.junit4)
}
