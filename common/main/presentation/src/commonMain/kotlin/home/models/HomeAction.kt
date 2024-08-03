package home.models

sealed class HomeAction {
    data object ShowUserProfile : HomeAction()
}