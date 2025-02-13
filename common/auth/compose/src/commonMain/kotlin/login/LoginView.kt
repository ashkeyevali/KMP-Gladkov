package login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.playzone_mobiledev.common.auth.compose.AuthRes
import login.models.LoginEvent
import login.models.LoginViewState
import theme.Theme

@Composable
fun LoginView(state: LoginViewState, eventHandler: (LoginEvent) -> Unit) {
    Column(modifier = Modifier.padding(30.dp), horizontalAlignment = Alignment.CenterHorizontally){
        Text("Login Now", color = Theme.colors.secondaryTextColor,
            fontSize = 24.sp, fontWeight = FontWeight.Bold, )
        Text(
            modifier = Modifier.padding(top = 15.dp),
            text = "Welcome back to PlayZone! Enter your email addres and your password to enjoy the latest features of PlayZone",
            color = Theme.colors.hintTextColor, fontSize = 14.sp, textAlign = TextAlign.Center)

        LoginInputView(
            email = state.email,
            password = state.password,
            isSending = state.isSending,
            isPasswordHidden = state.passwordHidden,
            onEmailChange = { eventHandler(LoginEvent.EmailChanged(it)) },
            onPasswordChange = { eventHandler(LoginEvent.PasswordChanged(it)) },
            onShowPasswordClicked = { eventHandler(LoginEvent.PasswordShowClicked) }
        )

        Spacer(modifier = Modifier.height(84.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = AuthRes.string.auth_forgot_password,
                color = Theme.colors.primaryAction,
                fontSize = 12.sp,
                modifier = Modifier.clickable { eventHandler(LoginEvent.ForgotPasswordClicked) }
            )
        }
        Spacer(modifier = Modifier.height(30.dp))




        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Theme.colors.primaryAction
            ),
            enabled = !state.isSending,
            shape = RoundedCornerShape(10.dp),
            onClick = { eventHandler(LoginEvent.LoginClicked) }) {
            Text(text = "Login Now", color = Theme.colors.primaryTextColor, fontSize = 16.sp, fontWeight = FontWeight.Bold)

        }

    }


}