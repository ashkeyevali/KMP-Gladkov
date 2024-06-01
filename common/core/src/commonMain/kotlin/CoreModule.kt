import database.dataBaseModule
import ktor.KtorModule
import org.kodein.di.DI
import serialization.serializationModule

val coreModule = DI.Module("coreModule") {
    importAll(
        serializationModule,
        dataBaseModule,
        KtorModule
    )
}