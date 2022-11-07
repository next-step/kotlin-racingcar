package racingCar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PositionTest {

    @Test
    fun `위치를 증가시켜야 합니다`() {
        val increasedPosition = Position(1).increase()

        assertThat(increasedPosition).isEqualTo(Position(2))
    }

    @Test
    fun `위치 객체 생성시 0과 음수는 예외를 뱉어야 합니다`() {
        assertThrows<java.lang.IllegalArgumentException> { Position(-1) }
    }
}
