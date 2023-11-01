package study.racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class SoloWinnerMakerTest {

    @ParameterizedTest
    @MethodSource("makeCorrectProvider")
    fun `차량수와 라운드수를 입력하면 차량별로 겹치지 않는 이동거리를 생성한다`(
        carCount: Int,
        roundCount: Int,
        sortIndex: List<Int>,
        expected: Map<Int, List<Boolean>>,
    ) {

        // Given & When
        val actual = SoloWinnerMaker.makeWinnerByFirstSorting(
            carCount, roundCount, sortIndex
        )

        println(actual)

        // Then
        assertAll(
            { assertThat(actual.size).isEqualTo(sortIndex.size) },
            { assertThat(actual).isEqualTo(expected) },
        )
    }

    @ParameterizedTest
    @MethodSource("wrongCarIndexErrorProvider")
    fun `단독 우승 방식을 위해 올바른 라운드 수를 입력 하지 않으면 에러를 반환 한다`(
        carCount: Int,
        roundCount: Int,
        sortIndex: List<Int>,
    ) {
        assertThrows<IllegalArgumentException> {
            SoloWinnerMaker.makeWinnerByFirstSorting(
                carCount, roundCount, sortIndex
            )
        }
    }

    @ParameterizedTest
    @MethodSource("notEnoughCarIndexErrorProvider")
    fun `단독 우승 방식을 생성할 때 사용되는 전체 차량 수와 우승자 선출용 차량 index의 수가 일치하지 않으면 에러를 반환 한다`(
        carCount: Int,
        roundCount: Int,
        sortIndex: List<Int>,
    ) {
        assertThrows<IllegalArgumentException> {
            SoloWinnerMaker.makeWinnerByFirstSorting(
                carCount, roundCount, sortIndex
            )
        }
    }

    companion object {

        @JvmStatic
        fun makeCorrectProvider() = listOf(
            Arguments.of(2, 1, listOf(0, 1), mapOf(0 to listOf(true), 1 to listOf(false))),
            Arguments.of(
                3,
                2,
                listOf(0, 1, 2),
                mapOf(0 to listOf(true, true), 1 to listOf(false, true), 2 to listOf(false, false))
            ),
            Arguments.of(2, 1, listOf(1, 0), mapOf(0 to listOf(false), 1 to listOf(true))),
            Arguments.of(
                3,
                2,
                listOf(2, 1, 0),
                mapOf(0 to listOf(false, false), 1 to listOf(false, true), 2 to listOf(true, true))
            ),
            Arguments.of(
                3,
                2,
                listOf(1, 0, 2),
                mapOf(0 to listOf(false, true), 1 to listOf(true, true), 2 to listOf(false, false))
            ),
        )

        @JvmStatic
        fun wrongCarIndexErrorProvider() = listOf(
            Arguments.of(2, 2, listOf(0, 1)),
            Arguments.of(3, 1, listOf(0, 1, 2)),
            Arguments.of(3, 3, listOf(0, 1, 2)),
        )

        @JvmStatic
        fun notEnoughCarIndexErrorProvider() = listOf(
            Arguments.of(2, 2, listOf(0, 1)),
            Arguments.of(3, 1, listOf(0, 1, 2)),
            Arguments.of(3, 3, listOf(0, 1, 2)),
        )
    }
}
