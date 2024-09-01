plugins{
    id("multiplatform-setup")
    kotlin("native.cocoapods")
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

    sourceSets.commonMain.dependencies{
        implementation(projects.common.core)
        implementation(projects.common.coreUtils)
        implementation(projects.common.umbrellaCore)
        implementation(projects.common.auth.api)
        implementation(projects.common.auth.presentation)
        implementation(projects.common.games.api)
        implementation(projects.common.main.api)
        implementation(projects.common.main.presentation)
//        implementation(projects.common.games.presentation)
    }

    sourceSets.iosMain.dependencies {
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
}

android{
    namespace = "com.example.playzone_mobiledev.common.umbrella_ios"
}