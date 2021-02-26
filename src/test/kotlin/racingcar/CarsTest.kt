package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarsTest {
    @Test
    fun makeCars() {
        // given
        val numberOfCars = 5

        // when
        val cars = Cars.makeCars(numberOfCars)

        // then
        assertThat(cars).hasSize(5)
    }
}
