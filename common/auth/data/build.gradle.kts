plugins {
    id("multiplatform-setup")
    id("android-setup")
    id("multiplatform-compose-setup")//todo delete it
    kotlin("plugin.serialization")
}

kotlin {
    sourceSets.commonMain.dependencies {
        api(project(":common:auth:api"))
        implementation(project(":common:core"))
        api(Dependencies.Kotlin.Serialization.serializarion)
    }
}

android {
    namespace = "com.example.playzone_mobiledev.common.auth.data"
}
