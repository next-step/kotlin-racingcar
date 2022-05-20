package raicing.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import raicing.strategy.MovingStrategy

class CarTests {

    @Test
    fun `position 값이 없이 Car 객체를 생성하는 경우 position은 INIT_POSITION ('0') 이다`() {
        val carName = "test"
        val car = Car(carName)

        assertThat(car.position).isEqualTo(Car.INIT_POSITION)
    }

    @Test
    fun `moveForward 조건이 true 인 경우 position은 1 이동한다`() {
        val carName = "test"
        val alwaysTrueStrategy = MovingStrategy { true }

        val car = Car(carName)
        val afterCar = car.moveForward(alwaysTrueStrategy)

        val actual = afterCar.position
        val expected = 1

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `moveForward 조건이 false 인 경우 position은 그대로이다`() {
        val carName = "test"
        val alwaysStopStrategy = MovingStrategy { false }

        val car = Car(carName)
        val afterCar = car.moveForward(alwaysStopStrategy)

        assertThat(afterCar.position).isEqualTo(car.position)
    }

    private fun Car(name: String, position: Int = 0) = Car(CarInfo(name), position)
}
