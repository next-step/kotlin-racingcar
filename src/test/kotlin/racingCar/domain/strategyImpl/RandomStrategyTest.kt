package racingCar.domain.strategyImpl

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class RandomStrategyTest {

    @Test
    fun isMoveTrueTest() {
        val randomStrategy = RandomStrategy()
        val isMove = randomStrategy.isMove(4)
        Assertions.assertTrue(isMove)
    }

    @Test
    fun isMoveFalseTest() {
        val randomStrategy = RandomStrategy()
        val isMove = randomStrategy.isMove(3)
        Assertions.assertFalse(isMove)
    }
}
