package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatCode
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class PositionTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 2])
    fun `값을 입력받아 위치를 생성할 수 있다`(givenValue: Int) {
        assertThat(Position(givenValue)).isNotNull
    }

    @Test
    fun `0보다 작은 값이 들어오면 예외를 던진다`() {
        assertThatCode { Position(-1) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `주어진 위치와 비교할 위치값을 비교하여 최대값을 리턴한다`() {
        val position = Position(1)

        assertThat(position.getMaxPosition(2)).isEqualTo(2)
    }
}
