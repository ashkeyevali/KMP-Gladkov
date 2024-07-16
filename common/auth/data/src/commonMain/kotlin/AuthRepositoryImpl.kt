import ktor.KtorAuthDataSource
import ktor.models.KtorAuthRequest
import model.Token

internal class AuthRepositoryImpl(
    private val remoteDataSource: KtorAuthDataSource
): AuthRepository {
    override suspend fun login(login: String, password: String): Token {
        return remoteDataSource.login(KtorAuthRequest(login, password)).mapToToken()
    }
}