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

    @Test
    fun `단일 우승자 조회`() {
        val racingGame = RacingGame(
            createStubRandomGenerator(4, 3, 3, 4, 3, 3, 4, 3, 3),
            listOf("a", "b", "c")
        )

        val gameResult = racingGame.start(3)

        assertThat(gameResult.winners).containsExactly("a")
    }

    @Test
    fun `공동 우승자 조회`() {
        val racingGame = RacingGame(
            createStubRandomGenerator(4, 3, 4, 4, 3, 4, 4, 3, 4),
            listOf("a", "b", "c")
        )

        val gameResult = racingGame.start(3)

        assertThat(gameResult.winners).containsExactlyInAnyOrder("a", "c")
    }
}
