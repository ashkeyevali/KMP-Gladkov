package ktor

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.path
import ktor.models.KtorAuthRequest
import ktor.models.TokenDto

class KtorAuthDataSource(private val httpClient: HttpClient) {
    suspend fun login(request: KtorAuthRequest): TokenDto {
        val response: TokenDto = httpClient.post {
            url {
                path("login")
                setBody(request)
            }
        }.body()
        return response
    }
}