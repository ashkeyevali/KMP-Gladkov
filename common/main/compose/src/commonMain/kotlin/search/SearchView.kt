package search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import search.models.SearchEvent
import search.models.SearchViewState
import theme.Theme

@Composable
fun SearchView(viewState: SearchViewState, eventHandler: (SearchEvent) -> Unit) {
    Column {
            TextField(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .height(56.dp),
                value = viewState.query,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color(0xFF1F2430),
                    textColor = Color(0xFF696C75),
                    cursorColor = Theme.colors.highlightTextColor,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                placeholder = { Text(text = "Search game", color = Theme.colors.hintTextColor) },
                shape = RoundedCornerShape(10.dp),
                onValueChange = {
                    eventHandler(SearchEvent.QueryChanged(it))
                })
        LazyColumn {
            viewState.games.forEach {
                item {
                    Text(
                        modifier = Modifier.
                        clickable{ eventHandler(SearchEvent.GameClicked)}.
                        padding(vertical = 8.dp, horizontal = 16.dp),
                        text = it.title,
                        color = Theme.colors.secondaryTextColor,
                        fontWeight = FontWeight.Medium
                        )
                }

            }

        }
    }

}