package study.racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class CarTest {

    @ParameterizedTest
    @CsvSource(
        "1, false", "2, false", "3, false", "4, true", "5, true",
        "6, true", "7, true", "8, true", "9, true"
    )
    fun `무작위 값이 4 이상 일 때 자동차 전진`(value: Int, expected: Boolean) {
        val car = Car("test")
        val originMoveCount = car.moveCount
        car.move(value)
        assertThat(originMoveCount < car.moveCount).isEqualTo(expected)
    }
}
