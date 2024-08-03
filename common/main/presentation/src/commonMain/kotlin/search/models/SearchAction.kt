package search.models

sealed class SearchAction {
    data object ShowGameDetail : SearchAction()
}