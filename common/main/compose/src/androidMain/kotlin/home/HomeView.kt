package home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import home.models.HomeAction
import home.models.HomeEvent
import home.models.HomeViewState
import theme.Theme

@Composable
fun HomeView(state: HomeViewState, actions: (HomeEvent) -> Unit) {
    Column {
        Spacer(modifier = Modifier.height(26.dp))
        Row(modifier = Modifier.clickable { actions(HomeEvent.UserProfileClicked)  }.padding(start = 24.dp, end = 24.dp, top = 26.dp)) {
            AsyncImage(modifier = Modifier.clip(RoundedCornerShape(28.dp)).size(56.dp),
                contentDescription = "avatar",
                model = state.avatarUrl,
                contentScale = ContentScale.FillBounds
            )

            Column(modifier = Modifier.padding(start = 20.dp)) {
                Text(
                    text = state.status,
                    color = Theme.colors.secondaryTextColor.copy(alpha = 0.5f),
                    fontSize = 12.sp
                )

                Text(
                    text = state.username,
                    color = Theme.colors.secondaryTextColor,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 4.dp)
                    )

            }
        }
    }

}