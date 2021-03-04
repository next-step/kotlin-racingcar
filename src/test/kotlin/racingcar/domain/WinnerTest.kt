package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class WinnerTest {

    @ParameterizedTest
    @MethodSource("provideStringsForIsBlank")
    fun `우승자 목록을 제공한다`(positions: Positions, winners: Array<String>) {
        assertThat(
            Winner(
                listOf(
                    Positions(
                        "pobi" to 1,
                        "crong" to 1,
                        "honux" to 1
                    ),
                    positions
                )
            ).names()
        ).containsExactlyInAnyOrder(*winners)
    }

    companion object {
        @JvmStatic
        fun provideStringsForIsBlank(): Stream<Arguments> = Stream.of(
            Arguments.of(
                Positions(
                    "pobi" to 2,
                    "crong" to 2,
                    "honux" to 1
                ),
                arrayOf("pobi", "crong")
            ),
            Arguments.of(
                Positions(
                    "pobi" to 1,
                    "crong" to 2,
                    "honux" to 1
                ),
                arrayOf("crong")
            ),
            Arguments.of(
                Positions(
                    "pobi" to 1,
                    "crong" to 2,
                    "honux" to 2
                ),
                arrayOf("crong", "honux")
            )
        )
    }
}
