package racingCar.domain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import racingCar.domain.strategy.MoveStrategy

class CarTest {

    private val moveStrategyTrue: MoveStrategy = MoveStrategy { true }
    private val moveStrategyFalse: MoveStrategy = MoveStrategy { false }

    @Test
    fun conditionalMoveTrueTest() {
        val car = Car("testCar", moveStrategyTrue)
        car.conditionalMove()

        Assertions.assertEquals(car.moveCount, 1)
    }

    @Test
    fun conditionalMoveFalseTest() {
        val car = Car("testCar", moveStrategyFalse)
        car.conditionalMove()

        Assertions.assertEquals(car.moveCount, 0)
    }

    @Test
    fun moveTest() {
        val car = Car("testCar")
        val moveCount = car.move()

        Assertions.assertEquals(moveCount, 1)
    }
}
