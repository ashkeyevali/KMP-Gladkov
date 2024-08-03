import ktor.KtorAuthDataSource
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider
import org.kodein.di.singleton
import settings.SettingsDataSource

val authModule = DI.Module("authModule") {
    bind<AuthRepository>() with singleton { AuthRepositoryImpl(instance(), instance()) }

    bind<SettingsDataSource>() with provider { SettingsDataSource(instance())}

    bind<KtorAuthDataSource>() with provider { KtorAuthDataSource(instance()) }
}