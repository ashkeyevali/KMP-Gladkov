plugins {
    id("multiplatform-compose-setup")
    id("android-setup")
    id("multiplatform-setup")
}

kotlin {
    sourceSets {
        commonMain{
            dependencies {
                implementation(projects.common.auth.presentation)
                implementation(projects.common.coreCompose)
                implementation(projects.common.coreUtils)
                
                implementation(Dependencies.Other.KViewModel.core)
                implementation(Dependencies.Other.KViewModel.compose)
                implementation(Dependencies.Other.KViewModel.odyssey)

                implementation(Dependencies.Other.OdysseyNavigation.core)
                implementation(Dependencies.Other.OdysseyNavigation.compose)
            }
        }
    }
}

android {
    namespace = "com.example.playzone_mobiledev.common.auth.compose"
}