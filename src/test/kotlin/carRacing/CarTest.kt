package carRacing

import carRacing.domain.Car
import carRacing.testcontroller.TestFalseMovementController
import carRacing.testcontroller.TestTrueMovementController
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CarTest {
    @ParameterizedTest
    @CsvSource("0", "1", "2")
    fun `자동차가 전진할 경우 position 값이 증가한다`(position: Int) {
        val car: Car = Car(TestTrueMovementController(), position)

        car.move()

        assertThat(car.position).isEqualTo(position + 1)
    }

    @ParameterizedTest
    @CsvSource("0", "1", "2")
    fun `자동차가 전진하지 못핡 경우 position 값이 증가하지 않는다`(position: Int) {
        val car: Car = Car(TestFalseMovementController(), position)

        car.move()

        assertThat(car.position).isEqualTo(position)
    }

    @Test
    fun `position 값 없이 생성된 자동차의 position은 1이다`() {
        val car: Car = Car(TestTrueMovementController())

        assertThat(car.position).isEqualTo(1)
    }

    @ParameterizedTest
    @CsvSource("0", "1", "2")
    fun `position 값이 주어진 자동차의 position은 주어진 값이다`(position: Int) {
        val car: Car = Car(TestTrueMovementController(), position)

        assertThat(car.position).isEqualTo(position)
    }
}
