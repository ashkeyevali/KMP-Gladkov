package login.models

sealed class LoginAction {
    data object OpenRegisterScreen : LoginAction()
    data object OpenForgotPasswordScreen : LoginAction()
    data object OpenMainFlow: LoginAction()
}