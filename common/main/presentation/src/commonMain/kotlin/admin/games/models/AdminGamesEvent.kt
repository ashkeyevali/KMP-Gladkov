package admin.games.models

sealed class AdminGamesEvent {
    data object AddGameClicked: AdminGamesEvent()
    data object ViewInited: AdminGamesEvent()
}