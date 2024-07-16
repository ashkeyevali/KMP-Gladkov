package ktor.models

import kotlinx.serialization.Serializable
import model.Token


@Serializable
data class TokenDto(
    val token: String
) {
    fun mapToToken(): Token = Token(token)
}