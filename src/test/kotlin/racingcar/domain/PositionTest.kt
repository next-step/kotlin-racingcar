package racingcar.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class PositionTest {

    @ParameterizedTest
    @ValueSource(ints = [-2, -1, -3, -100])
    fun `위치는 0미만일 수 없다`(value: Int) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Position.of(value) }
    }

    @ParameterizedTest
    @CsvSource("1, 2", "3, 4", "100, 101")
    fun `움직이면 위치가 1 증가한다`(start: Int, end: Int) {
        // given
        val position = Position.of(start)

        // when
        val moved = position.move()

        // then
        Assertions.assertThat(moved.value).isEqualTo(end)
    }
}
