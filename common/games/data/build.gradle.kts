plugins {
    id("multiplatform-setup")
    id("android-setup")
}

kotlin{
    sourceSets.commonMain.dependencies{
        api(project(":common:games:api"))
        implementation(project(":common:core"))
    }
    }


android {
    namespace = "com.example.playzone_mobiledev.common.games.data"
}