package database

import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.db.SqlSchema
import platform.PlatformConfiguration

expect class DbDriverFactory(platformConfiguration: PlatformConfiguration) {
    fun createDriver(schema: SqlSchema<QueryResult.Value<Unit>>, name: String): SqlDriver
}

