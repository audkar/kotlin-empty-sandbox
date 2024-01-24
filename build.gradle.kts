plugins {
    id("org.jetbrains.kotlin.android") version "1.9.22" apply false
    id("com.android.application") version "8.2.2" apply false
    id("com.google.devtools.ksp") version "1.9.22-1.0.17" apply false
    id("com.google.dagger.hilt.android") version "2.50" apply false
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
