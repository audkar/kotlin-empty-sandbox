import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id("com.android.library")
    kotlin("android")
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
    alias(libs.plugins.org.jetbrains.kotlin.plugin.compose)
}

android {
    compileSdk = 36
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
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
    }
}

dependencies {
    coreLibraryDesugaring(libs.com.android.tools.desugar.jdk.libs)
    implementation(androidx.appcompat.appcompat)
    implementation(libs.org.jetbrains.kotlinx.kotlinx.coroutines.android)
    implementation(androidx.annotation.annotation)
    implementation(androidx.core.coreKtx)
    implementation(libs.com.google.dagger.hilt.android)
    ksp(libs.com.google.dagger.hilt.android.compiler)
    implementation(platform(androidx.compose.composeBom))
    implementation(androidx.composeMaterial3.material3)
    implementation(androidx.composeUi.uiToolingPreview)
    debugImplementation(androidx.composeUi.uiTooling)
    implementation(androidx.composeMaterial.materialIconsCore)
    implementation(androidx.activity.activityCompose)
    implementation(androidx.lifecycle.lifecycleViewmodelCompose)
}
