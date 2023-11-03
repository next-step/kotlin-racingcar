package racingcar.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class GameResultsTest {

    @Test
    fun `단일 우승자 조회`() {
        val gameResults = GameResults.create(
            Positions(Position("a", 1), Position("b", 0)),
            Positions(Position("a", 1), Position("b", 1)),
            Positions(Position("a", 1), Position("b", 2)),
        )

        Assertions.assertThat(gameResults.winners).containsExactly("b")
    }

    @Test
    fun `공동 우승자 조회`() {
        val gameResults = GameResults.create(
            Positions(Position("a", 1), Position("b", 0)),
            Positions(Position("a", 1), Position("b", 1)),
            Positions(Position("a", 2), Position("b", 2)),
        )

        Assertions.assertThat(gameResults.winners).containsExactlyInAnyOrder("a", "b")
    }
}
