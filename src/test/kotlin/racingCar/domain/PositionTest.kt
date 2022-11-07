package racingCar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PositionTest {
    
    @Test
    fun `위치를 증가시켜야 합니다`() {
        val increasedPosition = Position(1).increase();

        assertThat(increasedPosition).isEqualTo(Position(2))
    }
}
