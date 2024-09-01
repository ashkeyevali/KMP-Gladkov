plugins {
    id(libs.plugins.kotlinMultiplatform.get().pluginId).apply(false)
    id(libs.plugins.androidApplication.get().pluginId).apply(false)
    id(libs.plugins.compose.get().pluginId).apply(false)
    id(libs.plugins.libres.get().pluginId).apply(false)
}
