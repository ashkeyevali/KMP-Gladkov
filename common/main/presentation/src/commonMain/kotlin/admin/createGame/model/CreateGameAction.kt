package admin.createGame.model

sealed class CreateGameAction {
    data object CloseScreen: CreateGameAction()
}