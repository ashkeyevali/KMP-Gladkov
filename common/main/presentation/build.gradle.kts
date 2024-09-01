plugins {
    id("multiplatform-setup")
}

kotlin {
    sourceSets {
        commonMain{
            dependencies {
                api(projects.common.auth.api)
                api(projects.common.main.api)
                api(projects.common.games.api)
                api(projects.common.core)
                implementation(libs.kviewmodel.core)
            }
        }
    }
}

android {
    namespace = "com.example.playzone_mobiledev.common.main.presentation"
}
