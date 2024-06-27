import di.Inject
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton
import platform.PlatformConfiguration


object PlatformSdk {
    fun init(
        configuration: PlatformConfiguration,
    ) {
        val umbrellaModule = DI.Module(
            name = "umbrellaModule",
            init = {
                bind<PlatformConfiguration>() with singleton {
                    configuration
                }
            }
            )
        Inject.createDependencies(
            DI.direct {
               importAll(
                   coreModule,
                   gamesModule,
                   umbrellaModule
               )
            }
        )
    }
}