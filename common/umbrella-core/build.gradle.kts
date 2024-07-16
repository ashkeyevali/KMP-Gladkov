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
                implementation(projects.common.auth.data)
                implementation(projects.common.games.data)
            }
        }
    }
}

android{
    namespace = "com.example.playzone_mobiledev.common.umbrella_core"
}
