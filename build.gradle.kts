buildscript {
    repositories {
        mavenCentral()
        google()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.1.2")
        classpath(kotlin("gradle-plugin", "1.6.10"))
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.40.5")
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

fun isNonStable(version: String): Boolean {
    val stableKeyword = listOf("FINAL", "GA").any { version.toUpperCase().contains(it) }
    val regex = "^[0-9,.v-]+(-r)?$".toRegex()
    val isStable = stableKeyword || regex.matches(version)
    return isStable.not()
}
