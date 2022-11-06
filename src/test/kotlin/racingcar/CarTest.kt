package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `전진 테스트`() {
        var toMoveCar = Car()
        val moveCount = 2
        val movedCar = Car(moveCount)

        for (i in 1..moveCount) {
            toMoveCar = toMoveCar.move()
        }

        assertEquals(movedCar, toMoveCar)
    }
}
