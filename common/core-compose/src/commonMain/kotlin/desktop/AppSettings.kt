package desktop

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.MutableStateFlow

class AppSettings {
    private val _windowState: MutableStateFlow<WindowState> = MutableStateFlow(WindowState.Custom(1024.dp, 800.dp))
    val windowState: MutableStateFlow<WindowState> = _windowState

    fun updateWindowState(windowState: WindowState) {
        _windowState.value = windowState
    }
}

val LocalAppSettings = staticCompositionLocalOf<AppSettings> {
    error("No AppSettings provided")
}