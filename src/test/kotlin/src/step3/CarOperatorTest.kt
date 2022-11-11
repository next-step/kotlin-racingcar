package src.step3

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class CarOperatorTest {

    @Test
    fun `주행 거리가 올바르게 나오는지`() {
        val cars = mutableListOf(Car())
        val tryCount = 1
        val randomValue = 5

        val moveCars = CarOperator.calculateCarMoveDistance(cars, tryCount, randomValue)

        Assertions.assertThat(moveCars[0].moveCounts[0]).isEqualTo(1)
    }
}
