package race.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class RacingResultTest {
    @ParameterizedTest
    @MethodSource("generateRacingResult")
    fun `가장 많이 전진한 자동차가 우승`(
        finalRound: RacingRound,
        expectWinners: List<String>
    ) {
        val racingResult = RacingResult(rounds = listOf(finalRound))
        val winners = racingResult.getWinners()

        winners.forEachIndexed { index, element ->
            assertEquals(expectWinners[index], element.name)
        }
    }

    companion object {
        @JvmStatic
        private fun generateRacingResult(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.of(
                    listOf(
                        RacingCar("A", 1),
                        RacingCar("B", 3),
                        RacingCar("C", 3)
                    ),
                    listOf(
                        "B", "C"
                    ),
                ),
                Arguments.of(
                    listOf(
                        RacingCar("A", 1),
                        RacingCar("B", 2),
                        RacingCar("C", 3)
                    ),
                    listOf(
                        "C"
                    ),
                ),
            )
        }
    }
}
