package game

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class CarFleetTest {

    private val advance = 4

    @ParameterizedTest
    @MethodSource("winner")
    fun `자동차들에서 우승자를 찾는다`(pobiCount: Int, crongCount: Int, honuxCount: Int, expected: List<String>) {
        // given
        val pobi = Car.of("pobi")
        val crong = Car.of("crong")
        val honux = Car.of("honux")
        repeat(pobiCount) { pobi.move(advance) }
        repeat(crongCount) { crong.move(advance) }
        repeat(honuxCount) { honux.move(advance) }

        val cars = listOf(pobi, crong, honux)
        val carFleet = CarFleet.from(cars)

        // when
        val actual = carFleet.findWinner()

        // then
        assertThat(actual).containsExactlyElementsOf(expected)
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
