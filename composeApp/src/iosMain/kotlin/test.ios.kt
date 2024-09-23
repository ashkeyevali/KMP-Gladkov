import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController

fun TestViewController(onClickListener: () -> Unit): UIViewController =
    ComposeUIViewController {
        Text(text = "Hello, iOS test!", modifier = Modifier.clickable { onClickListener.invoke() })
    }