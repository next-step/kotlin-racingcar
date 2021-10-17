package racingCar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `4 이상 움직이면 차가 움직인다`() {
        assertThat(Car().move(4).mileage).isEqualTo(1)
    }

    @Test
    fun `4 아래로 움직이면 차는 움직이지 않는다`() {
        assertThat(Car().move(3).mileage).isEqualTo(0)
    }
}
