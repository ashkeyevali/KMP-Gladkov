//import database.dataBaseModule
import ktor.KtorModule
import org.kodein.di.DI
import serialization.serializationModule
import settings.settingsModule

val coreModule = DI.Module("coreModule") {
    importAll(
        serializationModule,
        settingsModule,
//        dataBaseModule,
        KtorModule
    )
}