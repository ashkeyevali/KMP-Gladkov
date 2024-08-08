package admin.games

import GamesRepository
import admin.games.models.AdminGamesAction
import admin.games.models.AdminGamesEvent
import admin.games.models.AdminGamesViewState
import com.adeo.kviewmodel.BaseSharedViewModel
import di.Inject
import kotlinx.coroutines.launch

class AdminGamesVIewModel: BaseSharedViewModel<AdminGamesViewState, AdminGamesAction, AdminGamesEvent>(
    initialState = AdminGamesViewState()
) {

    private val gamesRepository: GamesRepository = Inject.instance()
    override fun obtainEvent(viewEvent: AdminGamesEvent) {
        when (viewEvent) {
            is AdminGamesEvent.AddGameClicked -> {
                viewAction = AdminGamesAction.OpenGameCreate

            }
            is AdminGamesEvent.ViewInited -> {
                fetchAllGames()
            }
        }
    }

    private fun fetchAllGames() {
        viewModelScope.launch {
            val games = gamesRepository.fetchAllGames()
            viewState = viewState.copy(games = games)
        }
    }

}