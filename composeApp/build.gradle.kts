import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.dsl.KotlinJsCompile
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    id(libs.plugins.compose.get().pluginId)
    id(libs.plugins.kotlinMultiplatform.get().pluginId)
    id(libs.plugins.androidApplication.get().pluginId)
    id(libs.plugins.kotlinCocoapods.get().pluginId)
}

version = "0.0.1"

kotlin {

    cocoapods{
        summary = "PlayZone IOS sdk"
        homepage = "https://github.com/ashkeyevali/KMP-Gladkov"
        ios.deploymentTarget = "14.0"

        framework {
            transitiveExport = false
            binaryOption("bundleId", "com.example.playzone_mobiledev.sharedsdk")
            baseName = "SharedSDK"
            linkerOpts("-lsqlite3")
            export(projects.common.core)
            export(projects.common.coreUtils)
            export(projects.common.umbrellaCore)
            export(projects.common.auth.api)
            export(projects.common.auth.presentation)
            export(projects.common.games.api)
            export(projects.common.main.api)
            export(projects.common.main.presentation)
//            export(projects.common.games.presentation)

        }
    }


    jvmToolchain(17)
    androidTarget()
    jvm()
    js {
        moduleName = "composeApp"
        browser {
            commonWebpackConfig {
                outputFileName = "composeApp.js"
            }
        }
        binaries.executable()
    }
    listOf(
        iosArm64(),
        iosX64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "ComposeApp"
            isStatic = false
        }
    }


    targets.withType<KotlinNativeTarget> {
        binaries{
            all{
                linkerOpts("-lsqlite3")
            }
        }}

     sourceSets {
         commonMain.dependencies {
             implementation(projects.common.umbrellaCore)
             implementation(projects.common.umbrellaCompose)
             implementation(projects.common.core)
             implementation(projects.common.coreCompose)
             implementation(projects.common.games.api)

             //comment on desktop build compose
             implementation(compose.ui)
             implementation(compose.foundation)
             implementation(compose.material)
             implementation(compose.material3)
             implementation(compose.runtime)
//             implementation(libs.compose.ui)
//             implementation(libs.compose.ui.tooling.preview)
//             implementation(libs.compose.material3)
//             implementation(libs.compose.foundation)
//             implementation(libs.androidx.activity.compose)

             implementation(libs.odyssey.compose)
             implementation(libs.odyssey.core)

             implementation(libs.kviewmodel.compose)
             implementation(libs.kviewmodel.core)
             implementation(libs.kviewmodel.odyssey)
//             debugImplementation(libs.compose.ui.tooling)
         }

         jvmMain.dependencies {
             implementation(compose.desktop.currentOs)
         }

         androidMain.dependencies {
             implementation(libs.androidx.appcompat)
                implementation(libs.androidx.activity.compose)
         }

         iosMain.dependencies {
             api(projects.common.core)
             api(projects.common.coreUtils)
             api(projects.common.umbrellaCore)
             api(projects.common.auth.api)
             api(projects.common.auth.presentation)
             api(projects.common.games.api)
             api(projects.common.main.api)
             api(projects.common.main.presentation)
//        api(projects.common.games.presentation)
         }
         jsMain.dependencies {
             implementation(compose.html.core)
         }
     }
}


android {
    namespace = "com.example.playzone_mobiledev.android"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.example.playzone_mobiledev.android"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.4"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

compose.desktop {
    application {
        mainClass = "Main_desktopKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Exe, TargetFormat.Deb)
            packageName = "com.example.playzone_mobiledev.desktop"
            packageVersion = "1.0.0"
        }
    }
}

compose.experimental {
    web.application{ }
}
