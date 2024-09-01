plugins{
    id("multiplatform-setup")
//    kotlin("plugin.serialization")
    id(libs.plugins.sqldelight.get().pluginId)
}

kotlin {
    sourceSets.commonMain.dependencies {
        api(libs.coroutines.core)
        api(libs.serialization.core)

        api(libs.ktor.core)
        api(libs.ktor.content.negotiation)
        api(libs.ktor.logging)
        api(libs.ktor.serialization)

        api(libs.kodein.core)

        implementation(libs.settings.core)
        implementation(libs.settings.noargs)
        implementation(libs.sqldelight.corotines)
        implementation(libs.sqldelight.runtime)

    }

    sourceSets.androidMain.dependencies {
        implementation(libs.ktor.android)
        implementation(libs.sqldelight.android.driver)
    }

    sourceSets.iosMain.dependencies {
        implementation(libs.ktor.ios)
        implementation(libs.sqldelight.ios.driver)
    }

    sourceSets.desktopMain.dependencies {
        implementation(libs.ktor.okhttp)
        implementation(libs.sqldelight.jvm.driver)
    }
    sourceSets.jsMain.dependencies {
        implementation(libs.sqldelight.javascript.driver)
        implementation(npm("sql.js", "1.11.0"))
        implementation(devNpm("copy-webpack-plugin", "9.1.0"))
    }






}
sqldelight {
    databases {
        create("PlayzoneDatabase") {
            packageName = "com.mobiledeveloper.playzone"
            schemaOutputDirectory = file("src/commonMain/sqldelight/com/mobiledeveloper/playzone/database/scheme")
            migrationOutputDirectory = file("src/commonMain/sqldelight/com/mobiledeveloper/playzone/database/migrations")

        }

    }
}


android {
    namespace = "com.example.playzone_mobiledev.common.core"
}

