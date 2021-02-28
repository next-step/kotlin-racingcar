package study.racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarTest {

    @Test
    fun `자동차를 움직인다`() {
        val car = Car()
        val oldDistance = car.distance
        car.moveCar(9)
        assertThat(oldDistance).isNotEqualTo(car.distance)
    }
}
