package admin.createGame.model

sealed class CreateGameEvent {
    data class TitleChanged(val title: String) : CreateGameEvent()
    data class DescriptionChanged(val description: String) : CreateGameEvent()
    data class VersionChanged(val version: String) : CreateGameEvent()
    data class SizeChanged(val size: String) : CreateGameEvent()
   data object SendClicked : CreateGameEvent()
}