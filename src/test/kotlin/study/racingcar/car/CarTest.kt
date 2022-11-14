package study.racingcar.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarTest {
    @Test
    fun `power 값이 4 이상일 때만 전진할 수 있다`() {
        val car = Car()
        car.move(4)
        assertThat(car.currentLocation).isEqualTo(2)
    }

    @Test
    fun `power 값이 4 미만이면 전진하지 않는다`() {
        val car = Car()
        car.move(3)
        assertThat(car.currentLocation).isNotEqualTo(2)
    }
}
