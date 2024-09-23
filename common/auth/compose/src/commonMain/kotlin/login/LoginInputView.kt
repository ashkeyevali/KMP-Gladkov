package login

import androidx.compose.runtime.Composable

@Composable
expect fun LoginInputView(
    email: String,
    password: String,
    isSending: Boolean,
    isPasswordHidden: Boolean,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onShowPasswordClicked: () -> Unit
)