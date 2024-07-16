import model.Token

interface AuthRepository {
    suspend fun login(email: String, password: String): Token
}