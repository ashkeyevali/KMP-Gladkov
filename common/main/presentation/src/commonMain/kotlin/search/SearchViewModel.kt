package search

import GamesRepository
import com.adeo.kviewmodel.BaseSharedViewModel
import di.Inject
import home.models.HomeAction
import home.models.HomeEvent
import home.models.HomeViewState
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import search.models.SearchAction
import search.models.SearchEvent
import search.models.SearchViewState

class SearchViewModel: BaseSharedViewModel<SearchViewState, SearchAction, SearchEvent>(
    initialState = SearchViewState()
) {
    private val gamesRepository: GamesRepository = Inject.instance()
    private var searchJob: Job? = null
    override fun obtainEvent(viewEvent: SearchEvent) {
        when (viewEvent) {
            is SearchEvent.QueryChanged -> searchGame(query = viewEvent.query)
            is SearchEvent.GameClicked -> showDetailGame()
        }
    }


    private fun showDetailGame() {
        viewAction = SearchAction.ShowGameDetail
    }

    private fun searchGame(query: String){
        searchJob = viewModelScope.launch {
            viewState = viewState.copy(query = query)//onValueChanged вызывает с новым значением однако если не обновить viewState то сработает обсервер со старым значением
            searchJob?.cancel()
            delay(500)
            viewState = try {
                val gamesResponse = gamesRepository.searchGame(query)
                viewState.copy(games = gamesResponse)
            } catch (e: Exception) {
                viewState.copy(games = emptyList())
            }

        }

    }

}