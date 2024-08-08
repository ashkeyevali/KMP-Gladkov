package admin.creategame

import admin.createGame.CreateGameViewModel
import admin.createGame.model.CreateGameAction
import admin.createGame.model.CreateGameEvent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import theme.AppTheme
import theme.Theme
import widgets.ActionButton
import widgets.CommonTextField

@Composable
fun CreateGameScreen() {
    val rootController = LocalRootController.current
    StoredViewModel({ CreateGameViewModel() }) { viewModel ->
        val state = viewModel.viewStates().observeAsState().value
        val action = viewModel.viewActions().observeAsState().value

        Column(modifier = Modifier.padding(16.dp)) {
            CommonTextField(text = state.title, "Enter title", enabled = !state.isSending) {
                viewModel.obtainEvent(CreateGameEvent.TitleChanged(it))
            }
            Spacer(modifier = Modifier.height(16.dp))

            CommonTextField(text = state.description, "Enter description", enabled = !state.isSending) {
                viewModel.obtainEvent(CreateGameEvent.DescriptionChanged(it))
            }
            Spacer(modifier = Modifier.height(16.dp))

            CommonTextField(text = state.version, "Enter version", enabled = !state.isSending) {
                viewModel.obtainEvent(CreateGameEvent.VersionChanged(it))
            }
            Spacer(modifier = Modifier.height(16.dp))

            CommonTextField(text = state.size.toString(), "Enter size", enabled = !state.isSending) {
                viewModel.obtainEvent(CreateGameEvent.SizeChanged(it))
            }
            Spacer(modifier = Modifier.height(16.dp))

            ActionButton(color = Theme.colors.primaryAction, text = "Save Changes", textColor = Theme.colors.primaryTextColor,
                enabled = !state.isSending) {
                viewModel.obtainEvent(CreateGameEvent.SendClicked)
            }
        }

        when(action) {
            is CreateGameAction.CloseScreen -> {
                rootController.popBackStack()
            }

            null -> {}
        }

    }

}