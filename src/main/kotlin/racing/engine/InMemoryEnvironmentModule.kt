package racing.engine

class InMemoryEnvironmentModule : EnvironmentModule {

    private val map: MutableMap<String, String> = HashMap()

    override fun put(key: String, value: String) {
        map[key] = value
    }

    override fun get(key: String): String? = map[key]
}
