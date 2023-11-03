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
        history.addRound(Round(listOf(Car.of("a"), Car.of("b"))))

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
    fun `마지막 자동차기록으로 자동차들에서 우승자를 찾는다`(
        lastPobiCount: Int,
        lastCrongCount: Int,
        lastHonuxCount: Int,
        expected: List<String>
    ) {
        // given
        val history = History()

        var pobi = Car.of("pobi", 0)
        var crong = Car.of("crong", 0)
        var honux = Car.of("honux", 0)
        var cars = listOf(pobi, crong, honux)

        history.addRound(Round(cars))

        pobi = Car.of("pobi", lastPobiCount)
        crong = Car.of("crong", lastCrongCount)
        honux = Car.of("honux", lastHonuxCount)
        cars = listOf(pobi, crong, honux)

        history.addRound(Round(cars))

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
