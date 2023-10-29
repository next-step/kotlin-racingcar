package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarTest {

    @Test
    fun `자동차는 특정 숫자 이상이 들어오면 움직인다`() {
        val car = Car(0)
        car.move(4)
        assertThat(car.position).isOne()
    }

    @Test
    fun `자동차는 특정 숫자 미만이 들어오면 움직이지 않는다`() {
        val car = Car(0)
        car.move(3)
        assertThat(car.position).isZero()
    }
}
