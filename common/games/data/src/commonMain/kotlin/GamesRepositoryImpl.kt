import ktor.KtorGamesDataSource
import ktor.models.KtorSearchGame
import ktor.models.Mapper
import model.CreateGameInfo
import model.Game
import sqldelight.SqlDelightGamesDataSource

class GamesRepositoryImpl(
    private val remoteDataSource: KtorGamesDataSource,
    private val localDataSource: SqlDelightGamesDataSource
): GamesRepository {
    override suspend fun fetchAllGames(): List<Game> {
        return remoteDataSource.fetchAllGames().map { it.mapToGame() }
    }

    override suspend fun searchGame(query: String): List<Game> {
        return remoteDataSource.searchGame(query).map { it.mapToGame() }
    }

    override suspend fun createGame(info: CreateGameInfo): Game {
        return remoteDataSource.createGame(Mapper().mapCreateGameToCreateGameInfoRequest(info)).mapToGame()
    }
}