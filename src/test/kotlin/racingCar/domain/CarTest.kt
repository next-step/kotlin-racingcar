package racingCar.domain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import racingCar.domain.strategy.MoveStrategy

class CarTest {

    private val moveStrategyAlwaysTrue: MoveStrategy = MoveStrategy { true }
    private val moveStrategyAlwaysFalse: MoveStrategy = MoveStrategy { false }

    @Test
    fun `isMove 함수가 true 일 경우 moveCount 증가`() {
        val car = Car("testCar", moveStrategy = moveStrategyAlwaysTrue)
        car.move()

        Assertions.assertEquals(car.moveCount, 1)
    }

    @Test
    fun `isMove 함수가 false 일 경우 moveCount 유지`() {
        val car = Car("testCar", moveStrategy = moveStrategyAlwaysFalse)
        car.move()

        Assertions.assertEquals(car.moveCount, 0)
    }
}
