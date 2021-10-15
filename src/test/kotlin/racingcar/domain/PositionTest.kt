package racingcar.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
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
        Assertions.assertThatCode { Position(-1) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
