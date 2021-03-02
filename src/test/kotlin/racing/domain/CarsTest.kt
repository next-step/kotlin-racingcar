package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racing.domain.random.TestRandomWrapper

internal class CarsTest {

    private val movementChecker = MovementChecker(TestRandomWrapper(9))

    @Test
    fun createNewCar() {
        val cars = Cars(movementChecker)
        cars.createNewCars(listOf("song"))

        assertThat(cars.names()).containsOnly(CarName("song"))
    }

    @Test
    fun getFarthestCars() {
        val cars = Cars(movementChecker)
        cars.createNewCars(listOf("song", "kim", "chang"))

        repeat(2) {
            cars[0].moveCar()
        }

        repeat(2) {
            cars[1].moveCar()
        }

        repeat(1) {
            cars[2].moveCar()
        }

        assertThat(cars.getFarthestCars()).containsOnly(cars[0], cars[1])
    }

    @Test
    fun moveAllCar() {
        val cars = Cars(movementChecker)
        cars.createNewCars(listOf("song", "kim"))

        repeat(3) {
            cars.moveAllCar()
        }

        assertThat(cars.positions()).containsOnly(CarPosition(3))
    }

    @Test
    fun getCarStates() {
        val cars = Cars(movementChecker)
        cars.createNewCars(listOf("song"))

        cars.getCarStates()
    }

    @Test
    fun size() {
        val names = listOf("a", "b", "c")
        val cars = Cars(movementChecker)
        cars.createNewCars(names)

        assertThat(cars.size()).isEqualTo(names.size)
    }
}
