plugins {
    id("multiplatform-compose-setup")
    id("android-setup")
}

kotlin {
    sourceSets {
        commonMain{
            dependencies {
                implementation(Dependencies.Other.KViewModel.core)
            }
        }
    }
}

android {
    namespace = "com.example.playzone_mobiledev.common.auth.compose"
}
