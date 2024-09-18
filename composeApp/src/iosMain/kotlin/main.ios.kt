import androidx.compose.ui.window.ComposeUIViewController
import navigation.navigationGraph
import platform.PlatformConfiguration
import platform.UIKit.UIViewController
import ru.alexgladkov.odyssey.compose.setup.OdysseyConfiguration
import ru.alexgladkov.odyssey.compose.setup.setNavigationContent
import theme.AppTheme
import theme.Theme
import navigation.navigationGraph


fun MainViewController(): UIViewController =
    ComposeUIViewController {
        PlatformSdk.init(configuration = PlatformConfiguration())
        AppTheme {
            val configuration = OdysseyConfiguration(
                backgroundColor = Theme.colors.primaryBackground
            )
            setNavigationContent(
                configuration = configuration, {}
            ) {
                navigationGraph()
            }
        }

    }