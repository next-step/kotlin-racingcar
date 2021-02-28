package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import racingcar.model.Car

class CarTest {

    @Test
    fun `차 전진`() {
        val car = Car()
        assertEquals(car.getProgress(), 0)

        car.moveForward()
        assertEquals(car.getProgress(), 1)
    }
}
