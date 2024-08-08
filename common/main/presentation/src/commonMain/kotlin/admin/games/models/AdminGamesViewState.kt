package admin.games.models

import model.Game

data class AdminGamesViewState(
    val games: List<Game> = emptyList()
)