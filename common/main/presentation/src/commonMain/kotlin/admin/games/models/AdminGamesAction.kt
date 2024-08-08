package admin.games.models

sealed class AdminGamesAction {
    data object OpenGameCreate: AdminGamesAction()
}