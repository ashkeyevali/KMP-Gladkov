plugins {
    id(libs.plugins.compose.get().pluginId)
    id(libs.plugins.kotlinMultiplatform.get().pluginId)
    id(libs.plugins.androidApplication.get().pluginId)
}

kotlin {
    jvmToolchain(17)
    androidTarget()
     sourceSets {
         commonMain.dependencies {
             implementation(projects.common.umbrellaCore)
             implementation(projects.common.umbrellaCompose)
             implementation(projects.common.core)
             implementation(projects.common.games.api)

             implementation(libs.compose.ui)
             implementation(libs.compose.ui.tooling.preview)
             implementation(libs.compose.material3)
             implementation(libs.androidx.activity.compose)

             implementation(libs.odyssey.compose)
             implementation(libs.odyssey.core)
//             debugImplementation(libs.compose.ui.tooling)
         }

         androidMain.dependencies {
             implementation(libs.androidx.appcompat)
                implementation(libs.androidx.activity.compose)
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
//    kotlinOptions {
//        jvmTarget = "17"
//    }
}
