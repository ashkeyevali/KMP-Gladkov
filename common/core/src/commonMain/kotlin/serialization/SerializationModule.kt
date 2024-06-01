package serialization

import kotlinx.serialization.json.Json
import ktor.KtorModule
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton

val serializationModule = DI.Module("serializationModule") {
    bind<Json>() with singleton {
        Json {
            ignoreUnknownKeys = true
            isLenient = true
            prettyPrint = true
            encodeDefaults = false
        }
    }
}