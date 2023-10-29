package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `차의 초기 위치는 0이다`() {
        val car = Car()

        assertThat(car.position).isEqualTo(0)
    }
}
