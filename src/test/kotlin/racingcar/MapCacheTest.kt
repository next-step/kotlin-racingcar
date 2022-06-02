package racingcar

import org.junit.jupiter.api.Test

private const val CAR_COUNT: Int = 500
private const val REPEAT_COUNT: Int = 1000
private const val TEST_COUNT = 5

class MapCacheTest {
    class Car(val name: String)

    private val cars: List<Car> = List(CAR_COUNT) { i: Int ->
        Car(List(i + 1) { it % 10 }.joinToString(""))
    }

    private val maxNameLength = cars.map { it.name }.maxOf { it.length }

    private val Car.displayNameCacheOn: String
        get() = cacheMap.getOrPut(this) { getDisplayName(this.name) }
    private val cacheMap = mutableMapOf<Car, String>()

    private fun getDisplayName(name: String): String {
        var displayName = name
        repeat(maxNameLength - name.length) { displayName += " " }
        return displayName
    }

    private val Car.displayNameCacheOff: String
        get() = getDisplayName(this.name)

    @Test
    fun `캐시 ON`() {
        repeat(TEST_COUNT) {
            val s = System.currentTimeMillis()
            repeat(REPEAT_COUNT) { cars.forEach { it.displayNameCacheOn } }
            val e = System.currentTimeMillis()
            println("캐시 ON ${e - s}")
        }
    }

    @Test
    fun `캐시 OFF`() {
        repeat(TEST_COUNT) {
            val s = System.currentTimeMillis()
            repeat(REPEAT_COUNT) { cars.forEach { it.displayNameCacheOff } }
            val e = System.currentTimeMillis()
            println("캐시 OFF ${e - s}")
        }
    }
}
