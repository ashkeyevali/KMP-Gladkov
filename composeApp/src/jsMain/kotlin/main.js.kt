import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import navigation.navigationGraph
import org.jetbrains.skiko.wasm.onWasmReady
import ru.alexgladkov.odyssey.compose.setup.OdysseyConfiguration
import ru.alexgladkov.odyssey.compose.setup.setNavigationContent
import theme.AppTheme
import theme.Theme
import platform.PlatformConfiguration


@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    onWasmReady {
        CanvasBasedWindow {
             PlatformSdk.init(configuration = PlatformConfiguration())
            AppTheme {
                val configuration = OdysseyConfiguration(
                    backgroundColor = Theme.colors.primaryBackground,
                )

                setNavigationContent(configuration, {}) {
                    navigationGraph()
                }
            }
        }
    }
}
