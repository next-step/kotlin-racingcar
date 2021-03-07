package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingGameTest {
    @Test
    fun `이동결과를 제공한다`() {
        val racingGame = RacingGame(CarsTest.cars(3))

        racingGame.play(5)

        assertThat(racingGame.positions.size).isEqualTo(5)

        for ((playStep, positions) in racingGame.positions.withIndex()) {
            assertThat(positions).allSatisfy {
                assertThat(it).isEqualTo(NamedPosition.Smart(position = playStep + 1))
            }
        }
    }
}
