package racingCar.domain

import org.junit.Assert.assertTrue
import org.junit.jupiter.api.Test

class RaceTest {
    @Test
    fun `Race 함수 테스트`() {
        val car1 = Car()
        val car2 = Car()
        val cars = listOf(car1, car2)
        val actual = Race(cars)
        actual.racing()

        assertTrue(car1.position >= 0)
        assertTrue(car2.position >= 0)
    }

}
