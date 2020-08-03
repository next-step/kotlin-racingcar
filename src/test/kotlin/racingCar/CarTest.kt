package racingCar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import racingCar.domain.Car

class CarTest {

    @Test
    fun `check car name over 5 length`() {
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            Car("chanheeee")
        }
    }

    @Test
    fun `check car running state`() {
        val car = Car("찬희")
        car.changeStateRacingCar(8)
        assertTrue(car.distance == 1)
    }

    @Test
    fun `check car stop state`() {
        val car = Car("찬희")
        car.changeStateRacingCar(3)
        assertTrue(car.distance == 0)
    }
}
