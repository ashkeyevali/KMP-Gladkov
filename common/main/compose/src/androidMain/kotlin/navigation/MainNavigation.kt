package navigation

import androidx.compose.material.Text
import events.EventsScreen
import home.HomeScreen
import navigation.tabs.BottomConfiguration
import navigation.tabs.EventsTab
import navigation.tabs.HomeTab
import navigation.tabs.SearchTab
import navigation.tabs.VideosTab
import ru.alexgladkov.odyssey.compose.extensions.bottomNavigation
import ru.alexgladkov.odyssey.compose.extensions.flow
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.extensions.tab
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import ru.alexgladkov.odyssey.compose.navigation.bottom_bar_navigation.BottomNavConfiguration
import search.SearchScreen
import videos.VideosScreen

fun RootComposeBuilder.mainFlow() {
    bottomNavigation(
        name = NavigationTree.Main.Dashboard.name,
        tabsNavModel = BottomConfiguration()
    ) {
        tab(HomeTab()) {
            screen(name = NavigationTree.Main.Home.name) {
                HomeScreen()

            }
            screen(name = NavigationTree.Main.Profile.name) {
                Text(text = "hello profile")
            }
        }
        tab(SearchTab()) {
            screen(name = NavigationTree.Main.Search.name) {
                SearchScreen()

            }
        }
        tab(EventsTab()) {
            screen(name = NavigationTree.Main.Events.name) {
                EventsScreen()

            }
        }
        tab(VideosTab()) {
            screen(name = NavigationTree.Main.Videos.name) {
                VideosScreen()

            }
        }
//        tab(DashboardTab()) {
//            screen(name = NavigationTree.Main.Dashboard.name) {
//                LoginScreen()
//            }
//        }

    }


}