package login.models

sealed class LoginEvent {
    data class EmailChanged(val email: String) : LoginEvent()
    data class PasswordChanged(val password: String) : LoginEvent()
    data object PasswordShowClicked : LoginEvent()
    data object LoginClicked : LoginEvent()
    data object RegisterClicked : LoginEvent()
    data object ForgotPasswordClicked : LoginEvent()
}