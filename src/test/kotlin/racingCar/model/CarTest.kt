package racingCar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `4 이상 움직이면 차가 움직인다`() {
        // given
        val car = Car()
        // when
        car.move { 4 }
        // then
        assertThat(car.mileage).isEqualTo(1)
    }

    @Test
    fun `4 아래로 움직이면 차는 움직이지 않는다`() {
        // given
        val car = Car()
        // when
        car.move { 3 }
        // then
        assertThat(Car().mileage).isEqualTo(0)
    }
}
