package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `전진 테스트`() {
        val moveCount = 2
        var toMoveCar = Car()
        val movedCar = Car(moveCount)

        val moveCondition = 4
        for (i in 1..moveCount) {
            toMoveCar.move(moveCondition)
        }

        assertEquals(movedCar, toMoveCar)
    }

    @Test
    fun `멈춤 테스트`() {
        val moveCount = 2
        var toMoveCar = Car()
        val stopCar = Car()

        val moveCondition = 3
        for (i in 1..moveCount) {
            toMoveCar.move(moveCondition)
        }

        assertEquals(stopCar, toMoveCar)
    }
}
