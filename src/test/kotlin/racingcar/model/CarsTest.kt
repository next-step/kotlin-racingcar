package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
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
        runGames(1, cars, canMove)

        // when
        val actualCarCount = cars.getCarCountWithScoreEqualOrGreaterThan(1)

        // then
        assertThat(actualCarCount).isEqualTo(expectedCarCount)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5])
    fun findMaxScore(gameCount: Int) {
        // given
        val carNames = listOf("Tesla", "Waymo", "Zoox")
        val cars = Cars.makeCars(carNames)
        runGames(gameCount, cars, true)

        // when
        val winners = cars.findMaxScore()

        // then
        assertThat(winners).isEqualTo(gameCount)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5])
    internal fun findWinners(gameCount: Int) {
        // given
        val carNames = listOf("Tesla", "Waymo", "Zoox")
        val cars = Cars.makeCars(carNames)
        runGames(gameCount, cars, true)

        // when
        val winners: List<String> = cars.findWinners()

        // then
        assertThat(winners).containsAll(carNames)
    }

    private fun runGames(gameCount: Int, cars: Cars, canMove: Boolean) {
        for (i in 1..gameCount) {
            cars.moveOnce(object : MoveStrategy {
                override fun canMove() = canMove
            })
        }
    }
}
