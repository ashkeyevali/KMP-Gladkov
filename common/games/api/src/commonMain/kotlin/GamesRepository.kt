import model.CreateGameInfo
import model.Game

interface GamesRepository {

    suspend fun fetchAllGames(): List<Game>
    suspend fun searchGame(query: String): List<Game>
    suspend fun createGame(info: CreateGameInfo): Game

}