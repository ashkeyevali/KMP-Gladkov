plugins{
    id("multiplatform-setup")
}

kotlin{
    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.common.core)
                implementation(projects.common.auth.data)
                implementation(projects.common.games.data)
                implementation(projects.common.main.data)
            }
        }
    }
}

android{
    namespace = "com.example.playzone_mobiledev.common.umbrella_core"
}
