package navigation

import forgot_password.ForgotPasswordScreen
import login.LoginScreen
import register.RegisterScreen
import ru.alexgladkov.odyssey.compose.extensions.flow
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder

fun RootComposeBuilder.authFlow() {
    flow(name = NavigationTree.AuthNavigation.AuthFlow.name) {
        screen(name = NavigationTree.AuthNavigation.Login.name) {
            LoginScreen()
        }

        screen(name = NavigationTree.AuthNavigation.Register.name) {
            RegisterScreen()
        }

        screen(name = NavigationTree.AuthNavigation.ForgotPassword.name) {
            ForgotPasswordScreen()
        }
    }

}