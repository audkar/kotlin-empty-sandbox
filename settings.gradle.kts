pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

rootProject.name = "kotlin-empty-sandbox"

plugins {
    id("com.gradle.develocity") version ("4.1.1")
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("androidx") {
            from("androidx.gradle:gradle-version-catalog:2025.12.00")
        }
        create("androidxA") {
            from("androidx.gradle:gradle-version-catalog-alpha:2025.12.00")
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
