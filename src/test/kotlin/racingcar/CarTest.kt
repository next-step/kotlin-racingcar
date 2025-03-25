package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `Position should be 0 when car is created`() {
        // given && when
        val car = Car()

        // then
        assertThat(car.position).isEqualTo(0)
    }
}
