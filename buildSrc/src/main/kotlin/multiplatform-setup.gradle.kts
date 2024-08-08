plugins {
    id("com.android.library")
    kotlin("multiplatform")
}

kotlin{
    applyDefaultHierarchyTemplate()

    jvm("desktop")
    androidTarget()
    iosX64()
    iosArm64()
    iosSimulatorArm64()
}