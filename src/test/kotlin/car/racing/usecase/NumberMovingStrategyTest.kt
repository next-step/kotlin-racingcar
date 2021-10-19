package car.racing.usecase

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class NumberMovingStrategyTest {

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `4 미만은 false`(condition: Int) {
        val movingStrategy = NumberMovingStrategy(NumberRandomGenerator())
        val result = movingStrategy.isMoveable()

        assertFalse(result)
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `4 이상은 true`(condition: Int) {
        val movingStrategy = NumberMovingStrategy(NumberRandomGenerator())
        val result = movingStrategy.isMoveable()

        assertTrue(result)
    }
}
