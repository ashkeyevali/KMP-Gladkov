package ktor.models

import kotlinx.serialization.Serializable
import model.Game

@Serializable
data class KtorSearchGame(
    val gameID: String,
    val title: String,
    val description: String,
    val version: String,
    val size: String
) {
    fun mapToGame(): Game {
        return Game(gameID, title)
    }
}