import ktor.KtorGamesDataSource
import model.Game
import sqldelight.SqlDelightGamesDataSource

class GamesRepositoryImpl(
    private val remoteDataSource: KtorGamesDataSource,
    private val localDataSource: SqlDelightGamesDataSource
): GamesRepository {
    override suspend fun fetchAllGames(): List<Game> {
        val localgames = localDataSource.fetchLocalGames()
        return if(localgames.isNotEmpty()) {
            return localgames.map { Game(it.game_id, it.game_title) }
        } else {
            val remote = remoteDataSource.fetchAllGames()
            remote.forEach {
                localDataSource.insertGame(it)
            }
            remote.map { it.mapToGame() }
        }
    }

    override suspend fun searchGame(query: String): List<Game> {
        val localgames = localDataSource.fetchLocalGames()
        return if(localgames.isNotEmpty()) {
            return localgames.map { Game(it.game_id, it.game_title) }
        } else {
            val remote = remoteDataSource.fetchAllGames()
            remote.forEach {
                localDataSource.insertGame(it)
            }
            remote.map { it.mapToGame() }
        }
    }
}