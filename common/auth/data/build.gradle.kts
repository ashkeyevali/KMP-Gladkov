plugins {
    id("multiplatform-setup")
    id(libs.plugins.serialization.get().pluginId)
}

kotlin {
    sourceSets.commonMain.dependencies {
        api(projects.common.auth.api)
        implementation(projects.common.core)
        api(libs.serialization.core)
        implementation(libs.settings.core)
    }
}

android {
    namespace = "com.example.playzone_mobiledev.common.auth.data"
}
