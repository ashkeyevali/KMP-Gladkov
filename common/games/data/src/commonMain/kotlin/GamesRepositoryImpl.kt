import ktor.KtorGamesDataSource
import model.Game
import sqldelight.SqlDelightGamesDataSource

class GamesRepositoryImpl(
    private val remoteDataSource: KtorGamesDataSource,
    private val localDataSource: SqlDelightGamesDataSource
): GamesRepository {
    override suspend fun fetchAllGames(): List<Game> {
        return remoteDataSource.fetchAllGames()
    }

    override suspend fun searchGame(query: String): Game {
        return remoteDataSource.searchGame(query)
    }
}