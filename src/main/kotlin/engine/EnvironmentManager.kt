package engine

object EnvironmentManager {

    private var environmentModule: EnvironmentModule = InMemoryEnvironmentModule()

    fun changeEnvironmentModule(environmentModule: EnvironmentModule) {
        this.environmentModule = environmentModule
    }

    fun put(key: String, value: String) {
        environmentModule.put(key, value)
    }

    fun get(key: String): String? = environmentModule.get(key)

    fun getOrDefault(key: String, defaultValue: String): String = environmentModule.get(key) ?: defaultValue
}
