import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
import com.github.benmanes.gradle.versions.updates.gradle.GradleReleaseChannel.CURRENT

buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${Versions.agp}")
        classpath(kotlin("gradle-plugin", Versions.kotlin))
        classpath("com.google.dagger:hilt-android-gradle-plugin:${Versions.dagger_hilt}")
    }
}

plugins {
    id("com.github.ben-manes.versions") version "0.36.0"
}

allprojects {
    repositories {
        google()
        jcenter()
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
                            "kotlin.time.ExperimentalTime",
                    "-XXLanguage:+InlineClasses",
                    "-Xallow-result-return-type"
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

tasks.named<DependencyUpdatesTask>("dependencyUpdates") {
    fun isNonStable(version: String): Boolean {
        val stableKeyword =
            listOf("FINAL", "GA").any { version.toUpperCase().contains(it) }
        val regex = "^[0-9,.v-]+(-r)?$".toRegex()
        val isStable = stableKeyword || regex.matches(version)
        return isStable.not()
    }
    resolutionStrategy {
        componentSelection {
            all {
                if (isNonStable(candidate.version) && !isNonStable(currentVersion)) {
                    reject("Release candidate")
                }
            }
        }
    }
    checkForGradleUpdate = true
    gradleReleaseChannel = CURRENT.id
}

tasks.wrapper {
    gradleVersion = "6.6.1"
    distributionType = Wrapper.DistributionType.ALL
}
