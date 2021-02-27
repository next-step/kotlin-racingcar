package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import racingcar.strategy.MoveStrategy

internal class CarsTest {
    @Test
    fun makeCars() {
        // when
        val carNames = listOf("Tesla", "Waymo", "Zoox")
        val cars = Cars.makeCars(carNames)

        // then
        assertThat(cars.getNumberOfCars()).isEqualTo(carNames.size)
    }

    @ParameterizedTest
    @CsvSource(value = ["true:3", "false:0"], delimiter = ':')
    fun getCarCountWithScoreEqualOrGreaterThan(canMove: Boolean, expectedCarCount: Int) {
        // given
        val carNames = listOf("Tesla", "Waymo", "Zoox")
        val cars = Cars.makeCars(carNames)
        cars.moveOnce(object : MoveStrategy {
            override fun canMove() = canMove
        })

        // when
        val actualCarCount = cars.getCarCountWithScoreEqualOrGreaterThan(1)

        // then
        assertThat(actualCarCount).isEqualTo(expectedCarCount)
    }
}
