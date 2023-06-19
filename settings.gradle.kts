rootProject.name = "kotlin-empty-sandbox"

plugins {
    id("com.gradle.enterprise") version("3.13.3")
}

include(":app", ":main")

gradleEnterprise {
  buildScan {
      termsOfServiceUrl = "https://gradle.com/terms-of-service"
      termsOfServiceAgree = "yes"
  }
}
