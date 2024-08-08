package admin.games

import admin.games.models.AdminGamesAction
import admin.games.models.AdminGamesEvent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import navigation.NavigationTree
import ru.alexgladkov.odyssey.compose.extensions.present
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import search.models.SearchEvent
import theme.Theme

@Composable
fun AdminGamesScreen() {
    val rootController = LocalRootController.current

    StoredViewModel({ AdminGamesVIewModel() }) {viewModel ->
        val viewState = viewModel.viewStates().observeAsState().value
        val viewActions = viewModel.viewActions().observeAsState().value

        Column {
            Row(modifier = Modifier.padding(16.dp)) {
                Text("Games List", fontSize = 28.sp, color = Theme.colors.secondaryTextColor)
                Spacer(modifier = Modifier.weight(1f))
                Icon(tint = Theme.colors.secondaryTextColor,
                    imageVector = Icons.Default.Add, contentDescription = "Add game", modifier = Modifier.clickable {
                        viewModel.obtainEvent(AdminGamesEvent.AddGameClicked)
                    })
            }

            LazyColumn {
                viewState.games.forEach {
                    item {
                        Text(
                            modifier = Modifier.
                            padding(vertical = 8.dp, horizontal = 16.dp),
                            text = it.title,
                            color = Theme.colors.secondaryTextColor,
                            fontWeight = FontWeight.Medium
                        )
                    }

                }
            }
        }



        when(viewActions) {
            is AdminGamesAction.OpenGameCreate -> {
                rootController.findRootController().present(NavigationTree.Admin.CreateGame.name)
            }

            null -> {
            }
        }

        LaunchedEffect(Unit) {
            viewModel.obtainEvent(AdminGamesEvent.ViewInited)
        }
    }
}