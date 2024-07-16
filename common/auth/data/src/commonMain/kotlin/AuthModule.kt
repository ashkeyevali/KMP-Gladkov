import ktor.KtorAuthDataSource
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider
import org.kodein.di.singleton

val authModule = DI.Module("authModule") {
    bind<AuthRepository>() with singleton { AuthRepositoryImpl(instance()) }

    bind<KtorAuthDataSource>() with provider { KtorAuthDataSource(instance()) }
}