package study.racing.process

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class RacingTest {

    @ParameterizedTest
    @MethodSource("racingFailArgumentProvider")
    fun `자동차 차량수, 라운드수 입력시 1이상의 정수가 아닌 경우 에러를 반환한다`(
        carCount: Int,
        roundCount: Int
    ) {
        assertThrows<IllegalArgumentException> {
            val racing = Racing()
            racing.playRacing(carCount, roundCount)
        }
    }

    companion object {
        @JvmStatic
        fun racingFailArgumentProvider() = listOf(
            Arguments.of(0, 1),
            Arguments.of(1, 0),
            Arguments.of(-1, 1),
            Arguments.of(1, -1),
            Arguments.of(0, -1),
        )
    }
}
