package admin.createGame.model

data class CreateGameViewState(
    val title: String = "",
    val description: String = "",
    val version: String = "",
    val size: Double = 0.0,
    val isSending: Boolean = false
)