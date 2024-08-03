import ktor.KtorMainDataSource


class MainRepositoryImpl(
    private val remoteDataSource: KtorMainDataSource
): MainRepository {
}