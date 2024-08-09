plugins{
    id("multiplatform-setup")
    id("android-setup")
    id("multiplatform-compose-setup")//todo delete it
    kotlin("plugin.serialization")
    id("app.cash.sqldelight") version "2.0.1"
}

kotlin {
    sourceSets.commonMain.dependencies {
        api(Dependencies.Kotlin.Coroutines.core)
        api(Dependencies.Kotlin.Serialization.serializarion)

        api(Dependencies.Ktor.core)
        implementation(Dependencies.Ktor.contentNegotiation)
        implementation(Dependencies.Ktor.logging)
        implementation(Dependencies.Ktor.seralization)

        api(Dependencies.Kodein.core)

        implementation(Dependencies.Settings.core)
        implementation(Dependencies.Settings.noargs)
        implementation(Dependencies.SqlDelight.coroutines)
        implementation(Dependencies.SqlDelight.runtime)

    }

    sourceSets.androidMain.dependencies {
        implementation(Dependencies.Ktor.android)
        implementation(Dependencies.SqlDelight.android)

    }

    sourceSets.iosMain.dependencies {
        implementation(Dependencies.Ktor.ios)
        implementation(Dependencies.SqlDelight.native)
    }

    sourceSets.desktopMain.dependencies {
        implementation(Dependencies.Ktor.okhttp)
        implementation(Dependencies.SqlDelight.jvm)

    }






}
sqldelight {
    databases {
        create("PlayzoneDatabase") {
            packageName = "com.mobiledeveloper.playzone"
            schemaOutputDirectory = file("src/commonMain/sqldelight/database/scheme")
            migrationOutputDirectory = file("src/commonMain/sqldelight/database/migrations")

        }

    }
}


android {
    namespace = "com.example.playzone_mobiledev.common.core"
}

