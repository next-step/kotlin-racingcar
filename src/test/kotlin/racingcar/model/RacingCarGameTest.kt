package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.FakeMoveStrategy

internal class RacingCarGameTest {
    @Test
    fun ready() {
        // given
        val carNames = listOf("Tesla", "Waymo", "Zoox")

        // when
        val racingCarGame = RacingCarGame.ready(carNames, FakeMoveStrategy())

        // then
        assertThat(racingCarGame.getCarCount()).isEqualTo(3)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 3, 26, 100])
    fun moveOnce(gameCount: Int) {
        // given
        val carNames = listOf("Tesla", "Waymo", "Zoox")
        val racingCarGame = RacingCarGame.ready(carNames, FakeMoveStrategy())

        // when
        for (i in 1..gameCount) {
            racingCarGame.moveOnce()
        }

        // then
        val cars = racingCarGame.getCars()
        assertThat(cars.findMaxScore()).isEqualTo(gameCount)
    }

    @Test
    fun findWinners() {
        // given
        val carNames = listOf("Tesla", "Waymo", "Zoox")
        val racingCarGame = RacingCarGame.ready(carNames, FakeMoveStrategy())
        racingCarGame.moveOnce()

        // when
        val winners: List<Car> = racingCarGame.getWinners()

        // then
        assertThat(winners).hasSize(3)
        assertThat(winners.map { it.name }).containsAll(carNames)
    }
}
