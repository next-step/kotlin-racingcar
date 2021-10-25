package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.dtos.GameInput

class RacingGameTest {
    @Test
    fun `GameResult 는 numberOfRounds 만큼의 RoundResult 를 가진다`() {
        val numberOfRounds = 5
        val gameInput = GameInput(listOf("car1"), numberOfRounds)
        val gameResult = RacingGame(gameInput).run()

        assertThat(gameResult.roundResults).hasSize(numberOfRounds)
    }

    @Test
    fun `GameResult의 각 RoundResult 는 carNames 와 같은 길이의 positions를 리턴한다`() {
        val carNames = listOf("car1", "car2", "car3")
        val gameInput = GameInput(carNames, 5)
        val gameResult = RacingGame(gameInput).run()

        assertThat(gameResult.roundResults).allMatch { it.results.size == carNames.size }
    }
}
