package ktor

import io.ktor.client.HttpClient
import model.Game

class KtorGamesDataSource(val httpClient: HttpClient) {

    fun fetchAllGames(): List<Game> {
        return emptyList()
    }

    fun searchGame(query: String): Game {
        return Game("0", "dd")
    }


}