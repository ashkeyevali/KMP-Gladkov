object Dependencies {

    object Kotlin {
        private const val version = "1.9.20"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
    }

    object Compose {
        private const val version = "1.5.10"
        const val gradlePlugin = "org.jetbrains.compose:compose-gradle-plugin:$version"
    }

    object Android {
        private const val version = "8.3.2"
        const val gradlePlugin = "com.android.tools.build:gradle:$version"
    }
}