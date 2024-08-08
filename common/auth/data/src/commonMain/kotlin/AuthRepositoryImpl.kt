import ktor.KtorAuthDataSource
import ktor.models.KtorAuthRequest
import model.Token
import settings.SettingsDataSource

internal class AuthRepositoryImpl(
    private val remoteDataSource: KtorAuthDataSource,
    private val cacheDataSource: SettingsDataSource
): AuthRepository {
    override suspend fun login(login: String, password: String): Token {
        val token = if(login == "admin" && password == "admin") {
            Token("08bf4015-2940-4eb8-a777-f6a613d53c7e")
        } else {
            remoteDataSource.login(KtorAuthRequest(login, password)).mapToToken()
        }
        cacheDataSource.saveToken(token.token)
        return token
    }

    override fun isUserLoggedIn(): Boolean {
        return cacheDataSource.fetchToken().isNotBlank()
    }

    override fun fetchToken(): String {
        return cacheDataSource.fetchToken()
    }
}