package theme

import LocalColorProvider
import PlayzoneColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import palette

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalColorProvider provides palette,
        content = content
    )
}

object Theme {
    val colors: PlayzoneColors
        @Composable
        get() = LocalColorProvider.current
}