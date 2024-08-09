import io.ktor.client.HttpClient
import ktor.KtorGamesDataSource
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider
import org.kodein.di.singleton
import sqldelight.SqlDelightGamesDataSource

val gamesModule = DI.Module("gamesModule") {
    bind<GamesRepository>() with singleton { GamesRepositoryImpl(instance(), instance()) }

    bind<KtorGamesDataSource>() with provider { KtorGamesDataSource(instance()) }

    bind<SqlDelightGamesDataSource>() with provider { SqlDelightGamesDataSource(instance()) }
}
