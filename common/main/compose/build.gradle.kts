plugins {
    id("multiplatform-compose-setup")
    id("android-setup")
    id("multiplatform-setup")
}

kotlin {
    sourceSets {
        commonMain{
            dependencies {
                implementation(projects.common.main.presentation)
                implementation(projects.common.coreCompose)
                implementation(projects.common.coreUtils)

                implementation(Dependencies.Other.KViewModel.core)
                implementation(Dependencies.Other.KViewModel.compose)
                implementation(Dependencies.Other.KViewModel.odyssey)

                implementation(Dependencies.Other.OdysseyNavigation.core)
                implementation(Dependencies.Other.OdysseyNavigation.compose)
            }
        }
        androidMain {
            dependencies {
                implementation(Dependencies.Image.Coil.core)
                implementation(Dependencies.Image.Coil.compose)
            }
        }
    }
}

android {
    namespace = "com.example.playzone_mobiledev.common.main.compose"
}