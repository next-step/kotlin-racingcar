package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import racingcar.strategy.MoveStrategy

internal class CarsTest {
    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3, 10])
    fun makeCars(numberOfCars: Int) {
        // when
        val cars = Cars.makeCars(numberOfCars)

        // then
        assertThat(cars.getNumberOfCars()).isEqualTo(numberOfCars)
    }

    @ParameterizedTest
    @CsvSource(value = ["true:3", "false:0"], delimiter = ':')
    fun getCarCountWithScoreEqualOrGreaterThan(canMove: Boolean, expectedCarCount: Int) {
        // given
        val cars = Cars.makeCars(3)
        cars.moveOnce(object : MoveStrategy {
            override fun canMove() = canMove
        })

        // when
        val actualCarCount = cars.getCarCountWithScoreEqualOrGreaterThan(1)

        // then
        assertThat(actualCarCount).isEqualTo(expectedCarCount)
    }
}
