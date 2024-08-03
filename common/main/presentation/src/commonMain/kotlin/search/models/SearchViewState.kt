package search.models

import model.Game

data class SearchViewState(
    val query: String = "",
    val games: List<Game> = emptyList()
)