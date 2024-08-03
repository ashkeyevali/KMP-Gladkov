package home

import com.adeo.kviewmodel.BaseSharedViewModel
import home.models.HomeAction
import home.models.HomeEvent
import home.models.HomeViewState

class HomeViewModel: BaseSharedViewModel<HomeViewState, HomeAction, HomeEvent>(
    initialState =
    HomeViewState(
        username = "ashkeyevli",
        avatarUrl = "https://64.media.tumblr.com/95577ba2c2f28974f84eac47bec1db09/f6ae847d6732005f-f3/s1280x1920/65b40b69f3788e6618975e9dbb5c7aed8495eef6.jpg",
        status = "Morning")
) {
    override fun obtainEvent(viewEvent: HomeEvent) {
        when (viewEvent) {
            is HomeEvent.UserProfileClicked -> {
               showUserProfile()
            }
        }
    }


    private fun showUserProfile() {
        viewAction = HomeAction.ShowUserProfile
    }

}