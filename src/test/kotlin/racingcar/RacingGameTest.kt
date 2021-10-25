package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.inputviews.GameInput

class RacingGameTest {
    @Test
    fun `GameResult 는 numberOfRounds 만큼의 RoundResult 를 가진다`() {
        val numberOfRounds = 5
        val gameInput = GameInput(1, numberOfRounds)
        val gameResult = RacingGame(gameInput).run()

        assertThat(gameResult.roundResults).hasSize(numberOfRounds)
    }

    @Test
    fun `GameResult의 각 RoundResult 는 numberOfCars 길이의 positions를 리턴한다`() {
        val numberOfCars = 3
        val gameInput = GameInput(numberOfCars, 5)
        val gameResult = RacingGame(gameInput).run()

        assertThat(gameResult.roundResults).allMatch { it.positions.size == numberOfCars }
    }
}
