plugins{
    id("multiplatform-setup")
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
                implementation(projects.common.main.compose)
                implementation(libs.kviewmodel.odyssey)
                implementation(libs.odyssey.core)
                implementation(libs.odyssey.compose)
            }
        }

        androidMain.dependencies {
            implementation(libs.androidx.activity.compose)

        }
    }
}

android{
    namespace = "com.example.playzone_mobiledev.common.umbrella_compose"
}
dependencies {
    implementation(project(":common:core"))
}
