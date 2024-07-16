plugins {
    id("multiplatform-setup")
    id("android-setup")
    id("multiplatform-compose-setup")//todo delete it or delete androidMain
}

android{
    namespace = "com.example.playzone_mobiledev.common.auth.api"
}