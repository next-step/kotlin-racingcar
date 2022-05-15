package racing.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class RoundsTest {

    @ParameterizedTest
    @MethodSource("generateData")
    fun `put and get test`(roundNo:Int, expected: Round) {
        //given
        val rounds = Rounds()

        //when
        rounds.put(roundNo, expected)

        //then
        assertThat(rounds.get(roundNo))
            .isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        private fun generateData(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    5,
                    Round(
                        listOf(
                            Car("testName").go(),
                            Car("testName").go(),
                            Car("testName"),
                            Car("testName"),
                            Car("testName").go()
                        )
                    )
                ),
                Arguments.of(
                    2,
                    Round(
                        listOf(
                            Car("testName"),
                            Car("testName").go()
                        )
                    )
                ),
                Arguments.of(
                    3,
                    Round(
                        listOf(
                            Car("testName"),
                            Car("testName").go(),
                            Car("testName").go()
                        )
                    )
                ),
                Arguments.of(
                    4,
                    Round(
                        listOf(
                            Car("testName"),
                            Car("testName"),
                            Car("testName"),
                            Car("testName").go(),
                            Car("testName").go()
                        )
                    )
                ),
                Arguments.of(
                    1,
                    Round(
                        listOf(
                            Car("testName").go(),
                            Car("testName"),
                            Car("testName").go(),
                            Car("testName").go()
                        )
                    )
                ),
            )
        }
    }
}