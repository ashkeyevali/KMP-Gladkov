package login


import androidx.compose.runtime.Composable
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import login.models.LoginAction
import navigation.NavigationTree
import register.RegisterScreen
import ru.alexgladkov.odyssey.compose.extensions.present
import ru.alexgladkov.odyssey.compose.extensions.push
import ru.alexgladkov.odyssey.compose.local.LocalRootController


@Composable
fun LoginScreen () {
    val rootController = LocalRootController.current

    StoredViewModel(factory = { LoginViewModel() }) { viewModel ->
        val state = viewModel.viewStates().observeAsState()
        val actions = viewModel.viewActions().observeAsState()
        LoginView(state = state.value) {
            viewModel.obtainEvent(it)
        }
        when(actions.value) {
            is LoginAction.OpenRegisterScreen -> {
                rootController.push(NavigationTree.AuthNavigation.Register.name)
            }
            is LoginAction.OpenForgotPasswordScreen -> {
                rootController.push(NavigationTree.AuthNavigation.ForgotPassword.name)
            }
            is LoginAction.OpenMainFlow -> {
                rootController.findRootController().present(NavigationTree.Main.Dashboard.name)
            }
            else -> {}
        }


    }


}
