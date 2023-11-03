package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingGameTest {

    @Test
    fun `경주에서 자동차 이동`() {
        val racingGame = RacingGame(
            createStubRandomGenerator(4, 3, 4, 3, 3, 4, 4, 4, 4),
            listOf("a", "b", "c")
        )

        val results = racingGame.start(3)

        assertThat(results).isEqualTo(
            GameResults.create(
                Positions(Position("a", 1), Position("b", 0), Position("c", 1)),
                Positions(Position("a", 1), Position("b", 0), Position("c", 2)),
                Positions(Position("a", 2), Position("b", 1), Position("c", 3)),
            )
        )
    }
}
