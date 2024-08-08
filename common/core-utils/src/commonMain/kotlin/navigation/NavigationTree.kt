package navigation

object NavigationTree {

    enum class SplashNavigation {
        Splash
    }
    enum class AuthNavigation {
        AuthFlow,
        Login,
        Register,
        ForgotPassword
    }

    enum class Main {
        Dashboard,
        Home,
        Search,
        Videos,
        Events,
        Profile,
        Game
    }

    enum class Admin {
        Dashboard, Games, Events, CreateGame
    }
}