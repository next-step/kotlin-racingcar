package race

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class RaceBoardTest {
    @ParameterizedTest
    @MethodSource("winnerTestData")
    fun `start 우승자를 알수있다`(
        cars: Cars,
        conditions: List<isMove>,
        winners: List<String>,
    ) {
        val moveConditions = MoveConditions(conditions)
        val raceBoard = RaceBoard(cars, moveConditions)

        val actual = raceBoard.start()

        assertThat(actual.winners).isEqualTo(winners)
    }

    companion object {
        @JvmStatic
        fun winnerTestData(): Stream<Arguments> =
            Stream.of(
                Arguments.of(
                    Cars(
                        listOf(
                            Car("a", 1),
                            Car("b", 2),
                            Car("c", 3),
                        ),
                    ),
                    listOf(false, false, true),
                    listOf("c"),
                ),
                Arguments.of(
                    Cars(
                        listOf(
                            Car("a", 1),
                            Car("b", 3),
                            Car("c", 3),
                        ),
                    ),
                    listOf(false, true, true),
                    listOf("b", "c"),
                ),
                Arguments.of(
                    Cars(
                        listOf(
                            Car("a", 1),
                            Car("b", 1),
                            Car("c", 1),
                        ),
                    ),
                    listOf(true, true, true),
                    listOf("a", "b", "c"),
                ),
            )
    }
}
