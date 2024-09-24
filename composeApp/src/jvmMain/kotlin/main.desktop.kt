import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import desktop.AppSettings
import desktop.LocalAppSettings
import desktop.WindowState
import navigation.navigationGraph
import platform.PlatformConfiguration
import ru.alexgladkov.odyssey.compose.setup.OdysseyConfiguration
import ru.alexgladkov.odyssey.compose.setup.setNavigationContent
import theme.AppTheme


fun main() {
    application {
        val appSettings = remember { AppSettings() }
        val windowState by appSettings.windowState.collectAsState()
        PlatformSdk.init(configuration = PlatformConfiguration())

        val state = rememberWindowState(
            width = 1024.dp,
            height = 800.dp,
            position = WindowPosition.Aligned(Alignment.Center)
        )

        Window (
            onCloseRequest = ::exitApplication,
            title = "Playzone Desktop",
            state = state
        ) {
            when(val ws = windowState) {
                is WindowState.Custom -> {
                    state.placement = WindowPlacement.Floating
                    state.size = DpSize(ws.width, ws.height)
                }
                is WindowState.FullScreen -> {
                    state.placement = WindowPlacement.Fullscreen
                }

                is WindowState.Maximized -> {
                    state.placement = WindowPlacement.Maximized
                }
            }
            AppTheme {
                val configuration = OdysseyConfiguration(
                    backgroundColor = theme.Theme.colors.primaryBackground
                )

                CompositionLocalProvider(
                    LocalAppSettings provides appSettings
                ) {
                    setNavigationContent(
                        configuration = configuration,
                        onApplicationFinish = ::exitApplication,
                    ) {
                        navigationGraph()
                    }                }

            }
        }
    }
}