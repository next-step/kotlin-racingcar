package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `minFuelThreshold 이상의 fuel 을 받으면 currentPosition 이 1 증가 한다`() {
        val car = Car(0, minFuelThreshold = 4)

        car.accelerate(5)

        assertThat(car.currentPosition).isEqualTo(1)
    }

    @Test
    fun `minFuelThreshold 이하의 fuel 을 받으면 currentPosition 이 증가 하지 않는다`() {
        val car = Car(0, minFuelThreshold = 4)

        car.accelerate(3)

        assertThat(car.currentPosition).isEqualTo(0)
    }
}
