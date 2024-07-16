object Dependencies {

    object Kodein {
        private const val version = "7.21.2"
        const val core = "org.kodein.di:kodein-di:$version"
    }

    object Kotlin {
        private const val version = "1.9.20"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"

        object Serialization {
            private const val version = "1.6.1"
            const val gradlePlugin = "org.jetbrains.kotlin:kotlin-serialization:1.9.20"
            const val serializarion = "org.jetbrains.kotlinx:kotlinx-serialization-core:$version"
        }

        object Coroutines {
            private const val version = "1.8.1"
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        }
    }

    object Compose {
        private const val version = "1.5.11"
        const val gradlePlugin = "org.jetbrains.compose:compose-gradle-plugin:$version"
    }

    object Ktor {
        private const val version = "2.3.11"
        const val core = "io.ktor:ktor-client-core:$version"
        const val contentNegotiation = "io.ktor:ktor-client-content-negotiation:$version"
        const val seralization = "io.ktor:ktor-serialization-kotlinx-json:$version"
        const val ios = "io.ktor:ktor-client-ios:$version"
        const val logging = "io.ktor:ktor-client-logging:$version"
        const val android = "io.ktor:ktor-client-android:$version"
        const val okhttp = "io.ktor:ktor-client-okhttp:$version"
        const val darwin = "io.ktor:ktor-client-darwin:$version"

    }

    object SqlDelight {
        private const val version = "2.0.1"
        const val gradlePlugin = "app.cash.sqldelight:gradle-plugin:$version"
        const val runtime = "app.cash.sqldelight:runtime:$version"
        const val android = "app.cash.sqldelight:android-driver:$version"
        const val native = "app.cash.sqldelight:native-driver:$version"
        const val jvm = "app.cash.sqldelight:sqlite-driver:$version"
        const val coroutines = "app.cash.sqldelight:coroutines-extensions:$version"
    }

    object Android {
        private const val version = "8.4.1"
        const val gradlePlugin = "com.android.tools.build:gradle:$version"
        const val composeActivity = "androidx.activity:activity-compose:1.9.0"

        object Compose {
            private const val version = "1.5.4"
            const val material = "androidx.compose.material3:material3:1.1.2"
            const val ui = "androidx.compose.ui:ui:$version"
            const val icons = "androidx.compose.material:material-icons-core:$version"
            const val runtime = "androidx.compose.runtime:runtime:1.5.4"


            // Android Studio Preview support
            const val preview= "androidx.compose.ui:ui-tooling-preview:$version"
            const val debugPreview = "androidx.compose.ui:ui-tooling:$version"

        }
    }

    object Other {
        object KViewModel {
            private const val version = "0.14"
            const val core = "com.adeo:kviewmodel:$version"
            const val compose = "com.adeo:kviewmodel-compose:$version"
            const val odyssey = "com.adeo:kviewmodel-odyssey:$version"
        }

        object OdysseyNavigation {
            private const val version = "1.3.61"
            const val core = "io.github.alexgladkov:odyssey-core:$version"
            const val compose = "io.github.alexgladkov:odyssey-compose:$version"
        }
    }

}