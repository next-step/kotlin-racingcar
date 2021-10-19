package car.racing.usecase

import car.racing.helper.AboveStandardGenerator
import car.racing.helper.BelowStandardGenerator
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class NumberMovingStrategyTest {

    @Test
    fun `조건 미만은 false`() {
        val movingStrategy = NumberMovingStrategy(BelowStandardGenerator())
        val result = movingStrategy.isMoveable()

        assertFalse(result)
    }

    @Test
    fun `조건 이상은 true`() {
        val movingStrategy = NumberMovingStrategy(AboveStandardGenerator())
        val result = movingStrategy.isMoveable()

        assertTrue(result)
    }
}
