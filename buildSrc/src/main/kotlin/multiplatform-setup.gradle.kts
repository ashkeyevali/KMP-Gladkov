plugins {
    id("com.android.library")
    id("org.jetbrains.compose")
    kotlin("multiplatform")
}

kotlin{
    applyDefaultHierarchyTemplate()
    js{
        browser()
    }

    jvm("desktop")
    androidTarget()
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    jvmToolchain(17)

    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
        }
    }
}

android {
    compileSdk = 34
}