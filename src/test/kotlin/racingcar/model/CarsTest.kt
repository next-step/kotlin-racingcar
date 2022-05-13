package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class CarsTest {

    @Test
    fun `경주할 자동차 이름이 하나도 없는 경우 에러가 발생한다`() {
        val carLists: List<Car> = emptyList()

        assertThrows<IllegalArgumentException> { Cars(carLists) }
    }

    @Test
    fun `Cars에 각 Car 들이 이동하거나 정지한다`() {
        // given
        val movingStrategy = MovingStrategy { true }
        val cars = Cars(List(3) { Car(name = CarName("abc"), movingStrategy = movingStrategy) })

        // when
        val expectedPosition = 3
        repeat(3) { cars.moveForwardCars() }

        // then
        cars.forEach { car ->
            assertThat(car.position).isEqualTo(expectedPosition)
        }
    }
}
