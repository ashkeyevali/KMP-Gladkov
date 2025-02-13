plugins {
    id("multiplatform-setup")
}

kotlin{
    sourceSets.commonMain.dependencies{
        api(project(":common:tournaments:api"))
        implementation(project(":common:core"))
    }
}


android {
    namespace = "com.example.playzone_mobiledev.common.tournaments.data"
}