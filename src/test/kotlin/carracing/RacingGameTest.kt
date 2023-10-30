package carracing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class RacingGameTest {
    private val carCount = 3
    private val racingCount = 5

    private val racingGame = RacingGame(carCount, racingCount)

    @Test
    fun `playGameTest`() {
        val round = 0
        val result = racingGame.playGame(round)
        assertAll(
            { assertThat(result.round).isEqualTo(round) },
            { assertThat(result.cars.size).isEqualTo(carCount) },
            { assertThat(result.result.size).isEqualTo(carCount) },
            { assertThat(result.cars[0].position).isIn(0, 1) },
            { assertThat(result.cars[1].position).isIn(0, 1) },
            { assertThat(result.cars[2].position).isIn(0, 1) }
        )
    }
}
