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
        manualMoveConditionIterator: ManualMoveConditionIterator,
        winners: List<String>,
    ) {
        val raceBoard = RaceBoard(cars, manualMoveConditionIterator)

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
                    ManualMoveConditionIterator(
                        listOf(
                            MoveCondition(PositiveNumber(1)),
                            MoveCondition(PositiveNumber(2)),
                            MoveCondition(PositiveNumber(5)),
                        ),
                    ),
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
                    ManualMoveConditionIterator(
                        listOf(
                            MoveCondition(PositiveNumber(1)),
                            MoveCondition(PositiveNumber(5)),
                            MoveCondition(PositiveNumber(5)),
                        ),
                    ),
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
                    ManualMoveConditionIterator(
                        listOf(
                            MoveCondition(PositiveNumber(5)),
                            MoveCondition(PositiveNumber(5)),
                            MoveCondition(PositiveNumber(5)),
                        ),
                    ),
                    listOf("a", "b", "c"),
                ),
            )
    }
}
