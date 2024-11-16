package race

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class RaceBoardTest {
    @ParameterizedTest
    @MethodSource("winnerTestData")
    fun `start 우승자를 알수있다`(
        cars: Cars,
        retryCount: Int,
        winners: List<String>,
    ) {
        val raceBoard = RaceBoard(cars, retryCount) { PositiveNumber(1) }

        val actual = raceBoard.start()

        assertAll(
            { assertThat(actual.winners).isEqualTo(winners) },
            { assertThat(actual.rounds).hasSize(retryCount) },
        )
    }

    companion object {
        @JvmStatic
        fun winnerTestData(): Stream<Arguments> =
            Stream.of(
                Arguments.of(Cars(listOf(Car("a", 1), Car("b", 2), Car("c", 3))), 1, listOf("c")),
                Arguments.of(Cars(listOf(Car("a", 1), Car("b", 3), Car("c", 3))), 1, listOf("b", "c")),
                Arguments.of(Cars(listOf(Car("a", 3), Car("b", 3), Car("c", 3))), 1, listOf("a", "b", "c")),
            )
    }
}
