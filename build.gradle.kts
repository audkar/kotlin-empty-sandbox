plugins {
    alias(libs.plugins.org.jetbrains.kotlin.android) apply false
    alias(libs.plugins.com.android.application)  apply false
    alias(libs.plugins.com.google.devtools.ksp) apply false
    alias(libs.plugins.com.google.dagger.hilt.android) apply false
    alias(libs.plugins.nl.littlerobots.version.catalog.update)
}

allprojects {
    tasks {
        withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
            compilerOptions {
                freeCompilerArgs = listOf(
                    "-progressive",
                    "-opt-in=" +
                            "kotlinx.coroutines.ExperimentalCoroutinesApi," +
                            "kotlinx.coroutines.FlowPreview," +
                            "kotlin.time.ExperimentalTime"
                )
            }
        }
    }
}
