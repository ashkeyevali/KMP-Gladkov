package search

import androidx.compose.runtime.Composable
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import navigation.NavigationTree
import ru.alexgladkov.odyssey.compose.extensions.present
import ru.alexgladkov.odyssey.compose.extensions.push
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import search.models.SearchAction

@Composable
fun SearchScreen() {
    val rootController = LocalRootController.current

    StoredViewModel({ SearchViewModel() }) { viewModel ->
        val viewStates = viewModel.viewStates().observeAsState()
        val viewActions = viewModel.viewActions().observeAsState()

        SearchView(viewStates.value) { event->
            viewModel.obtainEvent(event)

        }

        when(viewActions.value) {
            is SearchAction.ShowGameDetail -> rootController.findRootController()
                .present(NavigationTree.Main.Game.name)

            null -> {}
        }

    }

}