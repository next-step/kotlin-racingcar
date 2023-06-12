package racingCarTest

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingCar.Car

class CarMoveTest {
    @Test
    fun `전진 조건이 맞지 않는 경우`() {
        val car = Car(randomNumber = FixedNumberGenerator(3))
        car.move()
        assertThat(car.getDistance()).isEqualTo(0)
    }

    @Test
    fun `전진 조건이 맞는 경우`() {
        val car = Car(randomNumber = FixedNumberGenerator(7))
        car.move()
        assertThat(car.getDistance()).isEqualTo(1)
    }
}
