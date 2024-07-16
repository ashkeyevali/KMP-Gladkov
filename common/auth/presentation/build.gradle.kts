plugins {
    id("multiplatform-setup")
    id("android-setup")
    id("multiplatform-compose-setup")//todo delete it
}

kotlin {
    sourceSets {
        commonMain{
            dependencies {
                api(projects.common.auth.api)
                api(projects.common.games.api)
                api(projects.common.core)
                implementation(Dependencies.Other.KViewModel.core)
            }
        }
    }
}

android {
    namespace = "com.example.playzone_mobiledev.common.auth.presentation"
}
