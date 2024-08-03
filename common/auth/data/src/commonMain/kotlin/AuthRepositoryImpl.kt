import ktor.KtorAuthDataSource
import ktor.models.KtorAuthRequest
import model.Token
import settings.SettingsDataSource

internal class AuthRepositoryImpl(
    private val remoteDataSource: KtorAuthDataSource,
    private val cacheDataSource: SettingsDataSource
): AuthRepository {
    override suspend fun login(login: String, password: String): Token {
        val token =  remoteDataSource.login(KtorAuthRequest(login, password)).mapToToken()
        cacheDataSource.saveToken(token.token)
        return token
    }

    override fun isUserLoggedIn(): Boolean {
        return cacheDataSource.fetchToken().isNotBlank()
    }
}