package raicing.model

import io.mockk.every
import io.mockk.mockkObject
import io.mockk.unmockkAll
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import raicing.strategy.CarMovingStrategy

class CarTests {
    @AfterEach
    fun afterTests() {
        unmockkAll()
    }

    @Test
    fun `position 값이 없이 Car 객체를 생성하는 경우 position은 INIT_POSITION ('0') 이다`() {
        val carId = 0
        val car = Car(carId)

        assertThat(car.id).isEqualTo(carId)
        assertThat(car.position).isEqualTo(Car.INIT_POSITION)
    }

    @Test
    fun `moveForward 조건이 true 인 경우 position은 1 이동한다`() {
        val carId = 0
        val car = Car(carId)

        mockkObject(CarMovingStrategy)
        every {
            CarMovingStrategy.canMoveForward()
        } returns true

        val afterCar = car.moveForward(CarMovingStrategy)

        assertAll(
            {
                assertThat(afterCar.id).isEqualTo(carId)
                assertThat(afterCar.position).isEqualTo(car.position + 1)
            }
        )
    }

    @Test
    fun `moveForward 조건이 false 인 경우 position은 그대로이다`() {
        val carId = 0
        val car = Car(carId)

        mockkObject(CarMovingStrategy)
        every {
            CarMovingStrategy.canMoveForward()
        } returns false

        val afterCar = car.moveForward(CarMovingStrategy)

        assertAll(
            {
                assertThat(afterCar.id).isEqualTo(carId)
                assertThat(afterCar.position).isEqualTo(car.position)
            }
        )
    }
}
