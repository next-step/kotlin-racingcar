package game.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class RoundTest {

    @ParameterizedTest
    @MethodSource("winner")
    fun `자동차들에서 우승자를 찾는다`(pobiCount: Int, crongCount: Int, honuxCount: Int, expected: List<String>) {
        // given
        val pobi = Car.of("pobi", pobiCount)
        val crong = Car.of("crong", crongCount)
        val honux = Car.of("honux", honuxCount)
        val cars = listOf(pobi, crong, honux)
        val round = Round(cars)

        // when
        val actual = round.findWinners()

        // then
        Assertions.assertThat(actual).containsExactlyElementsOf(expected)
    }

    companion object {

        @JvmStatic
        fun winner(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(2, 2, 1, listOf("pobi", "crong")),
                Arguments.of(1, 2, 3, listOf("honux")),
                Arguments.of(1, 1, 1, listOf("pobi", "crong", "honux")),
            )
        }
    }
}
