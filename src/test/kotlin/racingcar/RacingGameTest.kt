package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingGameTest {
    @Test
    fun `이동결과를 제공한다`() {
        val racingGame = RacingGame(CarsTest.cars(3))

        racingGame.play(5)

        assertThat(racingGame.positions.size).isEqualTo(5)

        for ((index, positions) in racingGame.positions.withIndex()) {
            assertThat(positions).contains(
                Position(index + 1),
                Position(index + 1),
                Position(index + 1)
            )
        }
    }
}
