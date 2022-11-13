package racingCar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `자동차는 움직입니다`() {
        val car = Car()

        car.moveByStrategy({ true })

        assertThat(car).isEqualTo(Car.from(2))
    }
}
