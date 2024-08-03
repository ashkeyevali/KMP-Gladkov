import ktor.KtorMainDataSource
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider
import org.kodein.di.singleton

val mainModule = DI.Module("mainModule") {
    bind<MainRepository>() with singleton { MainRepositoryImpl(instance()) }

    bind<KtorMainDataSource>() with provider { KtorMainDataSource(instance()) }
}
