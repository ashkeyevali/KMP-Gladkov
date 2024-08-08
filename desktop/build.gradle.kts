plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
}

kotlin {
    jvm {
        withJava()
    }

    sourceSets {
        commonMain.dependencies {
            implementation(projects.common.core)
            implementation(projects.common.coreCompose)
            implementation(projects.common.coreUtils)
            implementation(projects.common.auth.compose)
            implementation(projects.common.games.api)
            implementation(projects.common.main.compose)
            implementation(projects.common.main.presentation)
            implementation(projects.common.umbrellaCore)
            implementation(projects.common.umbrellaCompose)

            implementation(Dependencies.Other.OdysseyNavigation.core)
            implementation(Dependencies.Other.OdysseyNavigation.compose)
        }

        jvmMain.dependencies {
            implementation(compose.desktop.currentOs)

        }
    }
}

compose.desktop {
    application {
        mainClass = "Main_desktopKt"

        nativeDistributions{
            targetFormats (
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Deb,
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Dmg,
                org.jetbrains.compose.desktop.application.dsl.TargetFormat.Msi
            )
            packageName = "Playzone-Admin"
            packageVersion = "1.0.0"

            windows {
                menuGroup = "PlayZone Admin"
                upgradeUuid = "945bb0ad-73a7-402f-ae45-882e0992925d"
            }
        }

    }

}