package ktor.models

import kotlinx.serialization.Serializable

@Serializable
class KtorAuthRequest(
    val login: String,
    val password: String
)