package admin.createGame

import AuthRepository
import GamesRepository
import admin.createGame.model.CreateGameAction
import admin.createGame.model.CreateGameEvent
import admin.createGame.model.CreateGameViewState
import com.adeo.kviewmodel.BaseSharedViewModel
import di.Inject
import kotlinx.coroutines.launch
import model.CreateGameInfo

class CreateGameViewModel: BaseSharedViewModel<CreateGameViewState, CreateGameAction, CreateGameEvent>(
    initialState = CreateGameViewState()
) {
    private val authRepository: AuthRepository = Inject.instance()
    private val gamesRepository: GamesRepository = Inject.instance()
    override fun obtainEvent(viewEvent: CreateGameEvent) {
        when(viewEvent) {
            is CreateGameEvent.TitleChanged -> {
                viewState = viewState.copy(title = viewEvent.title)
            }
            is CreateGameEvent.DescriptionChanged -> {
                viewState = viewState.copy(description = viewEvent.description)
            }
            is CreateGameEvent.VersionChanged -> {
                viewState = viewState.copy(version = viewEvent.version)
            }
            is CreateGameEvent.SizeChanged -> {
                viewState = viewState.copy(size = viewEvent.size.toDouble())
            }
            is CreateGameEvent.SendClicked -> {
                createGame()
            }
        }
    }

    private fun createGame() {
        viewModelScope.launch {
            viewState = viewState.copy(isSending = true)
            try {
                gamesRepository.createGame(
                    CreateGameInfo(
                    title = viewState.title,
                    description = viewState.description,
                    version = viewState.version,
                    size = viewState.size
                ))
                viewAction = CreateGameAction.CloseScreen

            } catch (e: Exception) {
                viewState = viewState.copy(isSending = false)
            }
        }
    }
}