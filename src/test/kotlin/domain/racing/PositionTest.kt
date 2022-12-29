package domain.racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PositionTest {

    @DisplayName("차가 전진한다")
    @Test
    fun moveTest() {
        val car = Position.create()

        car.move()

        assertThat(car.position).isEqualTo(1)
    }
}
