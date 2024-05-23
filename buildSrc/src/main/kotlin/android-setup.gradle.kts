
plugins {
    id("com.android.library")
}

android {
    compileSdk = 34
    defaultConfig {
        minSdk = 24
        lint.targetSdk = 34
        testOptions.targetSdk = 34
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    sourceSets {
        named("main") {
            manifest.srcFile("src/androidMain/AndroidManifest.xml")
            res.srcDirs("src/androidMain/res", "src/commonMain/resources")
        }
    }
}