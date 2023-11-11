package carRacing

import carRacing.domain.Car
import carRacing.testcontroller.TestFalseMovementController
import carRacing.testcontroller.TestTrueMovementController
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = ["", "abcdef"])
    fun `CarInfo 객체를 생성할 때 이름이 1자 이상 5자 이하가 아니면 IllegalArgumentException이 발생한다`(name: String) {
        assertThrows<IllegalArgumentException> {
            Car(name, TestTrueMovementController())
        }
    }

    @Test
    fun `자동차가 전진할 경우 position 값이 증가한다`() {
        val car: Car = Car("Car", movementController = TestTrueMovementController(), position = 1)

        car.move()

        assertThat(car.position).isEqualTo(2)
    }

    @Test
    fun `자동차가 전진하지 못할 경우 position 값이 증가하지 않는다`() {
        val car: Car = Car("Car", movementController = TestFalseMovementController(), position = 1)

        car.move()

        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `position 값 없이 생성된 자동차의 position은 1이다`() {
        val car: Car = Car("Car", movementController = TestTrueMovementController())

        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `position 값이 주어진 자동차의 position은 주어진 값이다`() {
        val car: Car = Car("Car", movementController = TestTrueMovementController(), position = 3)

        assertThat(car.position).isEqualTo(3)
    }
}
