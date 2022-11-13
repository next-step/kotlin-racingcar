package racingCar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarsTest {

    @Test
    fun `이동 전략에 따라 자동차를 움직여야 합니다`() {
        val cars = Cars(3) { true }

        cars.moveByStrategy()

        assertThat(cars.cars).containsExactly(Car(2), Car(2), Car(2))
    }
}
