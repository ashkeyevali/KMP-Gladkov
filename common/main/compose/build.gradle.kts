plugins {
    id("multiplatform-setup")
}

kotlin {
    sourceSets {
        commonMain{
            dependencies {
                implementation(projects.common.main.presentation)
                implementation(projects.common.coreCompose)
                implementation(projects.common.coreUtils)

                implementation(libs.kviewmodel.odyssey)
                implementation(libs.kviewmodel.compose)

                implementation(libs.odyssey.core)
                implementation(libs.odyssey.compose)
            }
        }
        androidMain {
            dependencies {
//                implementation(libs.coil.core)
//                implementation(libs.coil.compose)
            }
        }
    }
}

android {
    namespace = "com.example.playzone_mobiledev.common.main.compose"
}