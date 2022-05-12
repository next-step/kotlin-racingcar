package step3.racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `자동차 세팅 테스트`() {
        val input = (0..9).random()
        val car = Car.withMovements(input)
        assertEquals(car.movements.count { it }.plus(car.movements.count { !it }), input)
    }
}
