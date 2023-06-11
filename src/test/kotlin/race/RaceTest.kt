package race

import org.junit.jupiter.api.Test

class RaceTest {
    @Test
    fun 실행() {
        val car1 = Car()
        val car2 = Car()
        Race(listOf(car1, car2), 3).run()
    }
}
