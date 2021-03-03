package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.LastPlayerWinFakeMoveStrategy

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
    @ValueSource(ints = [4, 25, 122, 777])
    fun findMaxScore(gameCount: Int) {
        // given
        val carNames = listOf("Tesla", "Waymo", "Zoox")
        val cars = Cars.makeCars(carNames)
        runGames(gameCount, cars)

        // when
        val maxScore = cars.findMaxScore()

        // then
        assertThat(maxScore).isEqualTo(gameCount)
    }

    @ParameterizedTest
    @ValueSource(ints = [10, 20, 30, 100])
    fun findWinners(gameCount: Int) {
        // given
        val carNames = listOf("Tesla", "Waymo", "Zoox")
        val cars = Cars.makeCars(carNames)
        runGames(gameCount, cars)

        // when
        val winners: List<Car> = cars.findWinners()

        // then
        assertThat(winners.size).isEqualTo(1)
        assertThat(winners[0].name).isEqualTo("Zoox")
        assertThat(winners[0].score).isEqualTo(gameCount)
    }

    private fun runGames(gameCount: Int, cars: Cars) {
        for (i in 1..gameCount) {
            cars.moveOnce(LastPlayerWinFakeMoveStrategy(cars))
        }
    }
}
