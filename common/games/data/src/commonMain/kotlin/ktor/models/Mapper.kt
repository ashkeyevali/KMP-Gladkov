package ktor.models

import model.CreateGameInfo

class Mapper {
    fun mapCreateGameToCreateGameInfoRequest(createGame: CreateGameInfo): CreateGameInfoRequest {
        return CreateGameInfoRequest(
            title = createGame.title,
            description = createGame.description,
            version = createGame.version,
            size = createGame.size
        )
    }
}