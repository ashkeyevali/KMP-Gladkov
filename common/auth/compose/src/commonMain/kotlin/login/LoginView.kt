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

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            value = state.email,
            enabled = !state.isSending,
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
                eventHandler(LoginEvent.EmailChanged(it))
            })

        Spacer(modifier = Modifier.height(24.dp))

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            value = state.password,
            enabled = !state.isSending,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color(0xFF1F2430),
                textColor = Color(0xFF696C75),
                cursorColor = Theme.colors.highlightTextColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            visualTransformation = if (state.passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
            placeholder = { Text(text = "Your password", color = Theme.colors.hintTextColor) },
            trailingIcon = {
                Icon(
                    imageVector = if (state.passwordHidden) Icons.Default.Lock else Icons.Default.Clear,
                    contentDescription = "Password hidden",
                    modifier = Modifier.clickable {
                        eventHandler(LoginEvent.PasswordShowClicked)
                                                  },
                    tint = Theme.colors.hintTextColor,
                )
            },
            shape = RoundedCornerShape(10.dp),
            onValueChange = {
                eventHandler(LoginEvent.PasswordChanged(it))
            })

        Spacer(modifier = Modifier.height(84.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Forgot your password?",
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