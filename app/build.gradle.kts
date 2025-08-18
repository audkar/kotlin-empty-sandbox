@file:Suppress("UnstableApiUsage")

import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-parcelize")
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
    alias(libs.plugins.org.jetbrains.kotlin.plugin.compose)
}

android {
    compileSdk = 36
    namespace = "com.audkrs.emptyandroid"
    defaultConfig {
        applicationId = "com.audkrs.emptyandroid"
        minSdk = 23
        targetSdk = 36
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
            allDevices {
                maybeCreate<com.android.build.api.dsl.ManagedVirtualDevice>("pixel2api35").apply {
                    device = "Pixel 2"
                    apiLevel = 35
                    require64Bit = true
                    systemImageSource = "aosp-atd"
                    testedAbi = "x86_64"
                }
            }
        }
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures {
        compose = true
    }
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
    }
}

dependencies {
    implementation(project(":main"))
    coreLibraryDesugaring(libs.com.android.tools.desugar.jdk.libs)
    implementation(androidx.appcompat.appcompat)
    implementation(libs.org.jetbrains.kotlinx.kotlinx.coroutines.android)
    implementation(androidx.annotation.annotation)
    implementation(androidx.core.coreKtx)
    implementation(androidx.activity.activityKtx)
    implementation(libs.com.google.dagger.hilt.android)
    ksp(libs.com.google.dagger.hilt.android.compiler)
    debugImplementation(libs.com.squareup.leakcanary.leakcanary.android)
    constraints {
        debugImplementation("com.squareup.okio:okio:3.4.0") {
            because("Version 3.4.0 fixes the Signed to Unsigned Conversion Error vulnerability")
        }
    }
    implementation(platform(androidx.compose.composeBom))
    implementation(androidx.composeMaterial3.material3)
    implementation(androidx.composeUi.uiToolingPreview)
    debugImplementation(androidx.composeUi.uiTooling)
    debugImplementation(androidx.composeUi.uiTestManifest)
    implementation(androidx.composeMaterial.materialIconsCore)
    implementation(androidx.activity.activityCompose)
    implementation(androidx.lifecycle.lifecycleViewmodelCompose)
    implementation(libs.org.jetbrains.kotlinx.kotlinx.collections.immutable)
    lintChecks(libs.com.slack.lint.compose.compose.lint.checks)

    testImplementation(libs.junit)
    testImplementation(androidx.testExt.truth)
    testImplementation(libs.com.google.truth)
    testImplementation(libs.org.robolectric)
    testImplementation(libs.com.google.dagger.hilt.android.testing)
    kspTest(libs.com.google.dagger.hilt.android.compiler)
    testImplementation(platform(androidx.compose.composeBom))
    testImplementation(androidx.composeUi.uiTestJunit4)

    androidTestImplementation(libs.junit)
    androidTestImplementation(androidx.test.core)
    androidTestImplementation(androidx.test.runner)
    androidTestImplementation(androidx.test.rules)
    androidTestImplementation(androidx.testExt.junit)
    androidTestImplementation(androidx.testExt.truth)
    androidTestImplementation(libs.com.google.truth)
    androidTestImplementation(libs.com.google.dagger.hilt.android.testing)
    kspAndroidTest(libs.com.google.dagger.hilt.android.compiler)
    testImplementation(platform(androidx.compose.composeBom))
    androidTestImplementation(androidx.composeUi.uiTestJunit4)
}
