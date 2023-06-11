package race

import org.junit.jupiter.api.Test

class RaceTest {
    @Test
    fun 실행() {
        val condition = RandomMoveCondition()
        val car1 = Car(condition)
        val car2 = Car(condition)
        Race(listOf(car1, car2), 3).run()
    }
}
