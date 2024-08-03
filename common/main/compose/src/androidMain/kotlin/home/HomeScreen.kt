package home

import androidx.compose.runtime.Composable
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import home.models.HomeAction
import navigation.NavigationTree
import ru.alexgladkov.odyssey.compose.extensions.push
import ru.alexgladkov.odyssey.compose.local.LocalRootController

@Composable
fun HomeScreen() {
    val rootController = LocalRootController.current

    StoredViewModel({ HomeViewModel() }) {viewModel ->
        val viewState = viewModel.viewStates().observeAsState()
        val viewActions = viewModel.viewActions().observeAsState()
        HomeView(state = viewState.value) { event ->
            viewModel.obtainEvent(event)
        }
        when(viewActions.value) {
            is HomeAction.ShowUserProfile ->  rootController.push(
                screen = NavigationTree.Main.Profile.name
            )
            else -> {}
        }


    }

}