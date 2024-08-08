package admin.navigation

import admin.events.AdminEventsScreen
import admin.games.AdminGamesScreen
import androidx.compose.material.Text
import events.EventsScreen
import home.HomeScreen
import navigation.NavigationTree
import navigation.tabs.BottomConfiguration
import navigation.tabs.EventsTab
import navigation.tabs.HomeTab
import navigation.tabs.SearchTab
import navigation.tabs.VideosTab
import ru.alexgladkov.odyssey.compose.extensions.bottomNavigation
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.extensions.tab
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import search.SearchScreen
import videos.VideosScreen

fun RootComposeBuilder.adminFlow() {
    bottomNavigation(
        name = NavigationTree.Admin.Dashboard.name,
        tabsNavModel = BottomConfiguration()
    ) {
        tab(HomeTab()) {
            screen(name = NavigationTree.Admin.Games.name) {
                AdminGamesScreen()

            }
        }
        tab(EventsTab()) {
            screen(name = NavigationTree.Main.Events.name) {
                AdminEventsScreen()

            }
        }

    }


}