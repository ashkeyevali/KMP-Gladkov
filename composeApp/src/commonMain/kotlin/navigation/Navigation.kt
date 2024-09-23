package navigation

import SplashScreen
import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder


fun RootComposeBuilder.navigationGraph() {
    screen(name = NavigationTree.SplashNavigation.Splash.name) {
        SplashScreen()
    }

    screen(name = NavigationTree.Main.Game.name) {
        Text("Hello, game detail", color = Color.White)
    }
    authFlow()
    mainFlow()
}