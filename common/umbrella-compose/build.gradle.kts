plugins{
    id("multiplatform-compose-setup")
    id("multiplatform-setup")
    id("android-setup")
}

kotlin{
    sourceSets.commonMain.dependencies {
        implementation(project(":common:core"))
        implementation(project(":common:games:data"))
        implementation(project(":common:tournaments:data"))
        implementation(project(":common:auth:data"))
    }


}

android{
    namespace = "com.example.playzone_mobiledev.common.umbrella_compose"
}
dependencies {
    implementation(project(":common:core"))
    implementation(project(":common:core"))
}
