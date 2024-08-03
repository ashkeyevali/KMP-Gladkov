package login

import AuthRepository
import GamesRepository
import com.adeo.kviewmodel.BaseSharedViewModel
import di.Inject
import kotlinx.coroutines.launch
import login.models.LoginAction
import login.models.LoginEvent
import login.models.LoginViewState

class LoginViewModel: BaseSharedViewModel<LoginViewState, LoginAction, LoginEvent>(
    initialState = LoginViewState(email = "", password = "")
) {
    private val authRepository: AuthRepository = Inject.instance()


    init {
        isUserLoggedIn()
    }




    private fun isUserLoggedIn() {
        if(authRepository.isUserLoggedIn()) {
            viewAction = LoginAction.OpenMainFlow
        }
    }
    override fun obtainEvent(viewEvent: LoginEvent) {
        when(viewEvent){
            is LoginEvent.LoginClicked -> sendLogin()
            is LoginEvent.EmailChanged -> obtainEmailChanged(viewEvent.email)
            is LoginEvent.PasswordChanged -> obtainPasswordChanged(viewEvent.password)
            is LoginEvent.ForgotPasswordClicked -> openForgotPasswordScreen()
            is LoginEvent.RegisterClicked -> openRegisterScreen()
            is LoginEvent.PasswordShowClicked -> showPassword()
        }

    }

    private fun showPassword() {
        viewState = viewState.copy(
            passwordHidden = !viewState.passwordHidden
        )
    }

    private fun sendLogin() {
        viewState = viewState.copy(
            isSending = true
        )
        viewModelScope.launch {
            try {
                val response = authRepository.login(viewState.email, viewState.password)
                if(response.token.isNotBlank()) {
                    viewState = viewState.copy(
                        email = "", password = "",
                        isSending = false
                    )
                    viewAction = LoginAction.OpenMainFlow
                } else {
                    viewState = viewState.copy(
                        isSending = false
                    )
                }
            } catch (e: Exception) {
                viewState = viewState.copy(
                    isSending = false,
                )
            }
        }
    }

    private fun openRegisterScreen() {
        viewAction = LoginAction.OpenRegisterScreen
    }

    private fun openForgotPasswordScreen() {
        viewAction = LoginAction.OpenForgotPasswordScreen
    }

    private fun obtainEmailChanged(value: String) {
        viewState = viewState.copy(
            email = value
        )
    }

    private fun obtainPasswordChanged(value: String) {
        viewState = viewState.copy(
            password = value
        )
    }
}