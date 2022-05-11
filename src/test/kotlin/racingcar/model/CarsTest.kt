package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarsTest {

    @Test
    fun `Cars에 각 Car 들이 이동하거나 정지한다`() {
        // given
        val movingStrategy = MovingStrategy { true }
        val cars = Cars(List(3) { Car(it, movingStrategy = movingStrategy) })

        // when
        val expectedPosition = 3
        repeat(3) { cars.moveForwardCars() }

        // then
        cars.forEach { car ->
            assertThat(car.position).isEqualTo(expectedPosition)
        }
    }
}
