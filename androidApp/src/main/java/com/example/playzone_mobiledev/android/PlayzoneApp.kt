package com.example.playzone_mobiledev.android

import android.app.Application
import platform.PlatformConfiguration

class PlayzoneApp: Application() {

    override fun onCreate() {
        super.onCreate()
        PlatformSdk.init(initPlatformSDK())
    }
}

fun PlayzoneApp.initPlatformSDK() = PlatformConfiguration(applicationContext)