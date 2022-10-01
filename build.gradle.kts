buildscript {
    repositories {
        mavenCentral()
        google()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.3.0")
        classpath(kotlin("gradle-plugin", "1.7.10"))
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.43.2")
    }
}

allprojects {
    repositories {
        mavenCentral()
        google()
    }
    tasks {
        withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
            kotlinOptions {
                freeCompilerArgs = listOf(
                    "-progressive",
                    "-Xopt-in=" +
                            "kotlin.Experimental," +
                            "kotlinx.coroutines.ExperimentalCoroutinesApi," +
                            "kotlinx.coroutines.FlowPreview," +
                            "kotlin.time.ExperimentalTime"
                )
                jvmTarget = "1.8"
            }
        }
    }
}
