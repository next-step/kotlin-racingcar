package step3.domain.car.status

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PositionTest {
    @DisplayName("Position 생성 테스트")
    @Test
    fun `Position 생성 테스트`() {
        val position = Position(0)
        assertThat(position).isEqualTo(Position(0))
    }

    @DisplayName("Position 이동 테스트")
    @Test
    fun `Position 이동 테스트`() {
        val position = Position(0)
        position.move()
        assertThat(position).isEqualTo(Position(1))
    }
}
