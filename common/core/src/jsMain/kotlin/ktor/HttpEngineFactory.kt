package ktor

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngineConfig
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.js.Js

internal actual class HttpEngineFactory actual constructor() {
    actual fun createEngine(): HttpClientEngineFactory<HttpClientEngineConfig>  =
        Js
}