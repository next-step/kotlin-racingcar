package racingCar.domain.strategyImpl

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import racingCar.domain.strategy.MoveStrategy

class RandomStrategyTest {

    private val moveStrategy: MoveStrategy = RandomStrategy()

    @Test
    fun isMoveTest() {
        for (i in 1..100) {
            val result = moveStrategy.isMove()
            assertTrue(result == true || result == false)
        }
    }
}