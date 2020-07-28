package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingCarTest {

    @Test
    fun `increase distance when randomNum is between 4 and 9`() {
        val car = RacingCar()
        car.run(randomNum = 4)
        car.run(randomNum = 9)
        assertThat(car.getTotalDistance()).isEqualTo(2)
    }

    @Test
    fun `no change in distance when randomNum is between 0 and 3`() {
        val car = RacingCar()
        car.run(randomNum = 0)
        car.run(randomNum = 3)
        assertThat(car.getTotalDistance()).isEqualTo(0)
    }
}

