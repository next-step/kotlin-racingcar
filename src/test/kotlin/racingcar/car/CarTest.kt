package racingcar.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `자동차의 초기 위치는 0이다`() {
        val car = Car(CarName("name")) { true }
        assertThat(car.getPosition()).isZero()
    }

    @Test
    fun `자동차를 움직이면 위치가 1 증가한다`() {
        val car = Car(CarName("name")) { true }
        car.move()
        assertThat(car.getPosition()).isEqualTo(1)
    }
}
