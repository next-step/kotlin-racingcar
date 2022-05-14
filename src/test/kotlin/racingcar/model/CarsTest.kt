package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class CarsTest {

    @Test
    fun `가장 멀리 앞으로 간 우승자를 찾는다`() {
        // given
        val movingStrategy = MovingStrategy { true }

        val cars = Cars(
            listOf(
                Car(CarName("sam"), 5, movingStrategy),
                Car(CarName("kaka"), 2, movingStrategy),
                Car(CarName("luci"), 4, movingStrategy),
                Car(CarName("andy"), 5, movingStrategy)
            )
        )

        val expectedWinnerNames = listOf(CarName("sam"), CarName("andy"))
        val result = cars.findWinners().getCarNameList()

        assertThat(result).isEqualTo(expectedWinnerNames)
    }

    @Test
    fun `경주할 자동차 이름이 하나도 없는 경우 에러가 발생한다`() {
        val carLists: List<Car> = emptyList()

        assertThrows<IllegalArgumentException> { Cars(carLists) }
    }

    @Test
    fun `Cars에 각 Car 들이 이동하거나 정지한다`() {
        // given
        val movingStrategy = MovingStrategy { true }
        var carName = listOf("sam", "kaka", "luci")
        var cars = Cars(List(3) { Car(name = CarName(carName[it]), movingStrategy = movingStrategy) })

        // when
        val expectedPosition = 3
        repeat(3) {
            val moveForwardCars = cars.moveForwardCars()
            cars = moveForwardCars
        }

        // then
        cars.forEach { car ->
            assertThat(car.position).isEqualTo(expectedPosition)
        }
    }
}
