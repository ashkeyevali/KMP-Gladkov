
plugins {
    id("com.android.library")
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

kotlin{
    applyDefaultHierarchyTemplate()

    jvm("desktop")
    androidTarget()

    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)

        }

        androidMain.dependencies {
            sourceSets.androidMain.dependencies {
                implementation(Dependencies.Android.Compose.material)
                implementation(Dependencies.Android.Compose.ui)
                implementation(Dependencies.Android.Compose.preview)
                implementation(Dependencies.Android.Compose.icons)
                implementation(Dependencies.Android.Compose.runtime)
            }
        }

        named("desktopMain") {
            dependencies {
                implementation(compose.desktop.common)
            }
        }

    }
}