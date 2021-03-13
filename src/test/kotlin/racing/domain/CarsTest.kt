package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racing.domain.random.TestRandomWrapper

internal class CarsTest {

    private val movementChecker = MovementChecker(TestRandomWrapper(9))

    @Test
    fun createNewCar() {
        val cars = Cars(listOf("song"))

        assertThat(cars.cars.map { it.name.value }).containsOnly("song")
    }

    @Test
    fun getFarthestCars() {
        val cars = Cars(listOf("song", "kim", "chang"))

        repeat(2) {
            cars.cars[0].moveCarIfPossible(movementChecker)
        }

        repeat(2) {
            cars.cars[1].moveCarIfPossible(movementChecker)
        }

        repeat(1) {
            cars.cars[2].moveCarIfPossible(movementChecker)
        }

        assertThat(cars.getFarthestCars()).containsOnly(cars.cars[0], cars.cars[1])
    }

    @Test
    fun `moveAllCar all time move`() {
        val cars = Cars(listOf("song", "kim"))

        repeat(3) {
            val carStates = cars.moveAllCar(movementChecker)
            assertThat(carStates).extracting(("position")).containsOnly(CarPosition(it + 1))
        }

        assertThat(cars.cars.map { it.position }).containsOnly(CarPosition(3))
    }

    @Test
    fun `moveAllCar not move`() {
        val cars = Cars(listOf("song", "kim"))
        val movementChecker = MovementChecker(TestRandomWrapper(0))

        repeat(3) {
            val carStates = cars.moveAllCar(movementChecker)
            assertThat(carStates).extracting(("position")).containsOnly(CarPosition())
        }

        assertThat(cars.cars.map { it.position }).containsOnly(CarPosition(0))
    }

    @Test
    fun size() {
        val names = listOf("a", "b", "c")
        val cars = Cars(names)

        assertThat(cars.cars.size).isEqualTo(names.size)
    }
}
