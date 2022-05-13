package fixture

import engine.EnvironmentModule

class StubEnvironmentModule : EnvironmentModule {

    val hashMap = HashMap<String, String>()

    override fun put(key: String, value: String) {
        hashMap[key] = value
    }

    override fun get(key: String): String? = hashMap[key]
}
