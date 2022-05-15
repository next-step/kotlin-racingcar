package racing.engine

interface EnvironmentModule {

    fun put(key: String, value: String)
    fun get(key: String): String?
}
