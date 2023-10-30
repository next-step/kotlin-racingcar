package racingCar.domain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import racingCar.domain.strategy.MoveStrategy

class CarTest {

    private val moveStrategyTrue: MoveStrategy = MoveStrategy { true }
    private val moveStrategyFalse: MoveStrategy = MoveStrategy { false }

    @Test
    fun moveTrueTest() {
        val car = Car("testCar", moveStrategy = moveStrategyTrue)
        car.moveByStrategy()

        Assertions.assertEquals(car.moveCount, 1)
    }

    @Test
    fun moveFalseTest() {
        val car = Car("testCar", moveStrategy = moveStrategyFalse)
        car.moveByStrategy()

        Assertions.assertEquals(car.moveCount, 0)
    }
}
