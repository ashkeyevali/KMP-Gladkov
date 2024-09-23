package login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import theme.Theme

@Composable
actual fun LoginInputView(
    email: String,
    password: String,
    isSending: Boolean,
    isPasswordHidden: Boolean,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onShowPasswordClicked: () -> Unit
) {
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        value = email,
        enabled = !isSending,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color(0xFF1F2430),
            textColor = Color(0xFF696C75),
            cursorColor = Theme.colors.highlightTextColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        placeholder = { Text(text = "Your login", color = Theme.colors.hintTextColor) },
        shape = RoundedCornerShape(10.dp),
        onValueChange = {
            onEmailChange(it)
        })

    Spacer(modifier = Modifier.height(24.dp))

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        value = password,
        enabled = !isSending,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color(0xFF1F2430),
            textColor = Color(0xFF696C75),
            cursorColor = Theme.colors.highlightTextColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        visualTransformation = if (isPasswordHidden) PasswordVisualTransformation() else VisualTransformation.None,
        placeholder = { Text(text = "Your password", color = Theme.colors.hintTextColor) },
        trailingIcon = {
            Icon(
                imageVector = if (isPasswordHidden) Icons.Default.Lock else Icons.Default.Clear,
                contentDescription = "Password hidden",
                modifier = Modifier.clickable {
                  onShowPasswordClicked()
                },
                tint = Theme.colors.hintTextColor,
            )
        },
        shape = RoundedCornerShape(10.dp),
        onValueChange = {
            onPasswordChange(it)
        })
}