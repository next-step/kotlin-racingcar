package racingcar.domain.vo

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("위치(Position)")
class PositionTest {
    @Test
    fun `위치는 1보다 작을 수 없다`() {
        assertThatThrownBy { Position(0) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("위치는 1보다 작을 수 없습니다.")
    }

    @Test
    fun `위치 생성시 인자가 없으면 초기화 된다`() {
        assertThat(Position()).isEqualTo(Position(1))
    }

    @Test
    fun `위치가 변경되면 새 위치를 반환한다`() {
        val initial = 1
        val expected = initial + 1
        assertThat(Position(initial).moved()).isEqualTo(Position(expected))
    }
}
