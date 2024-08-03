package home.models

sealed class HomeEvent {
    data object UserProfileClicked : HomeEvent()
}