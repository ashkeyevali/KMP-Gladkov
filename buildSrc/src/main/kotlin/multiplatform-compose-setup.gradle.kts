
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

        named("desktopMain") {
            dependencies {
                implementation(compose.desktop.common)
            }
        }
    }
}