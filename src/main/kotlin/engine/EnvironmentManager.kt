package engine

class EnvironmentManager(private val environmentModule: EnvironmentModule) {

    fun put(key: String, value: String) {
        environmentModule.put(key, value)
    }

    fun get(key: String): String? = environmentModule.get(key)

    fun getOrDefault(key: String, defaultValue: String): String = environmentModule.get(key) ?: defaultValue
}
