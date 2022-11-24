package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PositionTest {

    @Test
    fun `위치가 증가됩니다`() {
        val increasedPosition = Position(1).increase()

        assertThat(increasedPosition).isEqualTo(Position(2))
    }

    @Test
    fun `위치 객체 생성시 0과 음수를 가진 위치 객체는 생성되지 않습니다`() {
        assertThrows<IllegalArgumentException> { Position(-1) }
    }
}
