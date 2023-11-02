package game.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class HistoryTest {

    @Test
    fun `라운드 자동차 히스트로를 추가한다`() {
        // given
        val history = History()

        // when
        history.addRound(listOf(Car.of("a"), Car.of("b")))

        // then
        assertAll(
            { assert(history.rounds.size == 1) },
            { assert(history.rounds[0].carList.size == 2) },
            { assert(history.rounds[0].carList[0].name == "a") },
            { assert(history.rounds[0].carList[1].name == "b") }
        )
    }

    @ParameterizedTest
    @MethodSource("winner")
    fun `자동차들에서 우승자를 찾는다`(pobiCount: Int, crongCount: Int, honuxCount: Int, expected: List<String>) {
        // given
        val pobi = Car.of("pobi", pobiCount)
        val history = History()
        val crong = Car.of("crong", crongCount)
        val honux = Car.of("honux", honuxCount)
        val cars = listOf(pobi, crong, honux)
        history.addRound(cars)

        // when
        val actual = history.findWinners()

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
