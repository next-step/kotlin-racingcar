package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import racingcar.strategy.MoveStrategy

internal class RacingCarGameTest {
    @Test
    fun ready() {
        // given
        val carNames = listOf("Tesla", "Waymo", "Zoox")
        val moveStrategy = object : MoveStrategy {
            override fun canMove() = true
        }

        // when
        val racingCarGame = RacingCarGame.ready(carNames, moveStrategy)

        // then
        assertThat(racingCarGame.getCarCount()).isEqualTo(3)
    }

    @ParameterizedTest
    @CsvSource(value = ["false:0", "true:3"], delimiter = ':')
    fun moveOnce(canMove: Boolean, expectedCarCount: Int) {
        // given
        val moveStrategy = object : MoveStrategy {
            override fun canMove() = canMove
        }
        val carNames = listOf("Tesla", "Waymo", "Zoox")
        val racingCarGame = RacingCarGame.ready(carNames, moveStrategy)

        // when
        racingCarGame.moveOnce()

        // then
        val cars = racingCarGame.getCars()
    }

    @Test
    fun findWinners() {
        // given
        val moveStrategy = object : MoveStrategy {
            override fun canMove() = true
        }
        val carNames = listOf("Tesla", "Waymo", "Zoox")
        val racingCarGame = RacingCarGame.ready(carNames, moveStrategy)
        racingCarGame.moveOnce()

        // when
        val winners: List<Car> = racingCarGame.getWinners()

        // then
        assertThat(winners).hasSize(3)
        assertThat(winners.map { car -> car.name }.toList()).containsAll(carNames)
    }
}
