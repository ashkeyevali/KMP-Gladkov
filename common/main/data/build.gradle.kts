
plugins {
    id("multiplatform-setup")
    id(libs.plugins.serialization.get().pluginId)
}

kotlin{
    sourceSets.commonMain.dependencies{
        api(project(":common:main:api"))
        implementation(project(":common:core"))
        api(libs.serialization.core)
    }
}


android {
    namespace = "com.example.playzone_mobiledev.common.main.data"
}