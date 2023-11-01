plugins {
    id("org.jetbrains.kotlin.android") version "1.9.10" apply false
    id("com.android.application") version "8.1.2" apply false
    id("com.google.devtools.ksp") version "1.9.20-1.0.13" apply false
    id("com.google.dagger.hilt.android") version "2.48.1" apply false
}

allprojects {
    tasks {
        withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
            kotlinOptions {
                freeCompilerArgs = listOf(
                    "-progressive",
                    "-opt-in=" +
                            "kotlinx.coroutines.ExperimentalCoroutinesApi," +
                            "kotlinx.coroutines.FlowPreview," +
                            "kotlin.time.ExperimentalTime"
                )
                jvmTarget = "17"
            }
        }
    }
}
