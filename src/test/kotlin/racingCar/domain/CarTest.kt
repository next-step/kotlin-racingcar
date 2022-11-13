package racingCar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `자동차는 움직여야 합니다`() {
        val car = Car()

        car.move()

        assertThat(car).isEqualTo(Car(Position(2)))
    }
}
