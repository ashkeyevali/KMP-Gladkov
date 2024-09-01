package sqldelight

import com.mobiledeveloper.playzone.PlayzoneDatabase
import com.mobiledeveloper.playzone.database.GAMES
import ktor.models.KtorSearchGame
class SqlDelightGamesDataSource(private val dataBase: PlayzoneDatabase) {
    fun fetchLocalGames(): List<GAMES> {
        return dataBase.gameQueries.getAllGames().executeAsList()
    }

    fun insertGame(game: KtorSearchGame) {
        dataBase.gameQueries.insertGames(game.gameID, game.title, game.version,game.size)
    }
}