
plugins {
    id("multiplatform-setup")
    id("android-setup")
    kotlin("plugin.serialization")
}

kotlin{
    sourceSets.commonMain.dependencies{
        api(project(":common:games:api"))
        implementation(project(":common:core"))
        api(Dependencies.Kotlin.Serialization.serializarion)
    }
    }


android {
    namespace = "com.example.playzone_mobiledev.common.games.data"
}