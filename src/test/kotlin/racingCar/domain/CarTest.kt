package racingCar.domain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun moveTest() {
        val car = Car("testCar")
        val moveCount = car.move()

        Assertions.assertEquals(moveCount, 1)
    }
}
