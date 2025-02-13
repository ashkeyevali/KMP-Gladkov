import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyShortcut
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.MenuBar
import androidx.compose.ui.window.Tray
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberNotification
import androidx.compose.ui.window.rememberTrayState
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

        val trayState = rememberTrayState()
        val notification = rememberNotification("Notification", "Hello from Playzone Desktop!")

        val state = rememberWindowState(
            width = 1024.dp,
            height = 800.dp,
            position = WindowPosition.Aligned(Alignment.Center)
        )

        Tray(
            state = trayState,
            icon = rememberVectorPainter(Icons.Default.Search),
            menu = {
                Item("push", onClick = { trayState.sendNotification(notification = notification) })
                Item("exit app", onClick = {exitApplication()})
            }
        )// status bar configuration on desktop

        Window (
            onCloseRequest = ::exitApplication,
            title = "Playzone Desktop",
            state = state
        ) {
            MenuBar {
                Menu(text = "File", mnemonic = 'F')
                     {
                    Item("Save", onClick = { println("Save clicked") }, shortcut = KeyShortcut(Key.S, ctrl = true))
                }
            }
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