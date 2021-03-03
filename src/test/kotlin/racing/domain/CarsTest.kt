package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racing.domain.random.TestRandomWrapper

internal class CarsTest {

    private val movementChecker = MovementChecker(TestRandomWrapper(9))

    @Test
    fun createNewCar() {
        val cars = Cars(listOf("song"), movementChecker)

        assertThat(cars.cars.map { it.name.name }).containsOnly("song")
    }

    @Test
    fun getFarthestCars() {
        val cars = Cars(listOf("song", "kim", "chang"), movementChecker)

        repeat(2) {
            cars.cars[0].moveCar()
        }

        repeat(2) {
            cars.cars[1].moveCar()
        }

        repeat(1) {
            cars.cars[2].moveCar()
        }

        assertThat(cars.getFarthestCars()).containsOnly(cars.cars[0], cars.cars[1])
    }

    @Test
    fun moveAllCar() {
        val cars = Cars(listOf("song", "kim"), movementChecker)

        repeat(3) {
            cars.moveAllCar()
        }

        assertThat(cars.cars.map { it.position }).containsOnly(CarPosition(3))
    }

    @Test
    fun getCarStates() {
        val cars = Cars(listOf("song"), movementChecker)

        cars.getCarStates()
    }

    @Test
    fun size() {
        val names = listOf("a", "b", "c")
        val cars = Cars(names, movementChecker)

        assertThat(cars.cars.size).isEqualTo(names.size)
    }
}
