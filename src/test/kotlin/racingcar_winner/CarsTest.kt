package racingcar_winner

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar_winner.model.Car
import racingcar_winner.model.Cars

class CarsTest {

    private val listOfCars = listOf<Car>(
        Car("Phobi"), Car("John"), Car("James")
    )

    @Test
    fun `차들이 앞으로 갔을때`() {
        listOfCars[0].tryToMoveForward(5)
        listOfCars[1].tryToMoveForward(6)
        listOfCars[2].tryToMoveForward(7)

        val cars = Cars(listOfCars)
        val progressList = cars.getProgressOfCars()

        assertThat(progressList).isEqualTo(listOf("Phobi : -", "John : -", "James : -"))
    }

    @Test
    fun `차들이 그대로 멈출때`() {
        listOfCars[0].tryToMoveForward(1)
        listOfCars[1].tryToMoveForward(2)
        listOfCars[2].tryToMoveForward(3)

        val cars = Cars(listOfCars)
        val progressList = cars.getProgressOfCars()

        assertThat(progressList).isEqualTo(listOf("Phobi : ", "John : ", "James : "))
    }
}
