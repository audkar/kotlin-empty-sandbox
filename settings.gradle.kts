pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

rootProject.name = "kotlin-empty-sandbox"

plugins {
    id("com.gradle.develocity") version ("4.5.0")
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("androidx") {
            from("androidx.gradle:gradle-version-catalog:2026.08.01")
        }
        create("androidxA") {
            from("androidx.gradle:gradle-version-catalog-alpha:2026.08.01")
        }
    }
}

include(":app", ":main")

develocity {
    buildScan {
        publishing {
            onlyIf { false }
        }
        buildScan {
            termsOfUseUrl = "https://gradle.com/help/legal-terms-of-use"
            termsOfUseAgree = "yes"
        }
    }
}
