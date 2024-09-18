import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import navigation.navigationGraph
import platform.PlatformConfiguration
import ru.alexgladkov.odyssey.compose.setup.OdysseyConfiguration
import ru.alexgladkov.odyssey.compose.setup.setNavigationContent
import theme.AppTheme


fun main() {
    application {
        PlatformSdk.init(configuration = PlatformConfiguration())

        Window (
            onCloseRequest = ::exitApplication,
            title = "Playzone Desktop",
            state = rememberWindowState(
                width = 1024.dp,
                height = 800.dp,
                position = WindowPosition.Aligned(Alignment.Center)
            )
        ) {
            AppTheme {
                val configuration = OdysseyConfiguration(
                    backgroundColor = theme.Theme.colors.primaryBackground
                )
                setNavigationContent(
                    configuration = configuration,
                    onApplicationFinish = ::exitApplication,
                ) {
                    navigationGraph()
                }
            }
        }
    }
}