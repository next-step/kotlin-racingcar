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
        val inputCarCount = 4
        val moveStrategy = object : MoveStrategy {
            override fun canMove() = true
        }

        // when
        val racingCarGame = RacingCarGame.ready(inputCarCount, moveStrategy)

        // then
        assertThat(racingCarGame.getCarCount()).isEqualTo(inputCarCount)
    }

    @ParameterizedTest
    @CsvSource(value = ["false:0", "true:4"], delimiter = ':')
    fun moveOnce(canMove: Boolean, expectedCarCount: Int) {
        // given
        val moveStrategy = object : MoveStrategy {
            override fun canMove() = canMove
        }
        val racingCarGame = RacingCarGame.ready(4, moveStrategy)

        // when
        racingCarGame.moveOnce()

        // then
        val cars = racingCarGame.getCars()
        val countWithScoreGreaterThanOne = cars.getCarCountWithScoreEqualOrGreaterThan(1)
        assertThat(countWithScoreGreaterThanOne).isEqualTo(expectedCarCount)
    }
}
