plugins{
    id("multiplatform-compose-setup")
    id("multiplatform-setup")
    id("android-setup")
}

kotlin{
    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.common.core)
                implementation(projects.common.coreCompose)
                implementation(projects.common.umbrellaCore)
                implementation(projects.common.coreUtils)
                implementation(projects.common.games.data)
                implementation(projects.common.tournaments.data)
                implementation(projects.common.auth.data)
                implementation(projects.common.auth.compose)
                implementation(Dependencies.Other.KViewModel.odyssey)
                implementation(Dependencies.Other.KViewModel.compose)
                implementation(Dependencies.Other.KViewModel.core)
                implementation(Dependencies.Other.OdysseyNavigation.core)
                implementation(Dependencies.Other.OdysseyNavigation.compose)
            }
        }

        androidMain.dependencies {
            implementation(Dependencies.Android.composeActivity)

        }
    }
}

android{
    namespace = "com.example.playzone_mobiledev.common.umbrella_compose"
}
dependencies {
    implementation(project(":common:core"))
}
