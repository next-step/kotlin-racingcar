package step3.domain.car.status

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PositionTest {
    @DisplayName("Position 생성 테스트")
    @Test
    fun `Position 생성 테스트`() {
        val position = Position(0)
        assertThat(position).isEqualTo(Position(0))
    }

    @DisplayName("Position 이동 예외처리 테스트")
    @Test
    fun `Position 이동 예외처리 테스트`() {
        assertThatThrownBy { Position(-1) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("자동차의 위치는 0 이상이어야 합니다.")
    }

    @DisplayName("Position 이동 테스트")
    @Test
    fun `Position 이동 테스트`() {
        val position = Position(0)
        position.move()
        assertThat(position).isEqualTo(Position(1))
    }

    @DisplayName("Position 위치 반환 테스트")
    @Test
    fun `Position 위치 반환 테스트`() {
        val position = Position(0)
        assertThat(position.getPosition()).isEqualTo(0)
    }
}
