package ktor

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.http.path
import io.ktor.util.InternalAPI
import ktor.models.KtorSearchGame
import ktor.models.KtorSearchRequest
import model.Game

class KtorGamesDataSource(private val httpClient: HttpClient) {

    suspend fun fetchAllGames(): List<KtorSearchGame> {
        val response: List<KtorSearchGame> = httpClient.post {
            url {
                path("games/search")
                setBody( KtorSearchRequest(searchQuery = ""))
            }
        }.body()
        return response
    }

    suspend fun searchGame(query: String): List<KtorSearchGame> {
        val response: List<KtorSearchGame> = httpClient.post {
            url {
                path("games/search")
                setBody( KtorSearchRequest(searchQuery = ""))
            }
        }.body()
        return response
    }

}