package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CarsTest {
    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3, 10])
    fun makeCars(numberOfCars: Int) {
        // when
        val cars = Cars.makeCars(numberOfCars)

        // then
        assertThat(cars.getNumberOfCars()).isEqualTo(numberOfCars)
    }
}
