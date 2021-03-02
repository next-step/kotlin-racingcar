package racingcar_winner

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest

class CarsTest {

    private val listOfCars = listOf<Car>(Car("Phobi"), Car("John"), Car("James"))

    @Test
    fun `차들의 Progress 확인`() {
        listOfCars[0].tryToMoveForward(5)
        listOfCars[1].tryToMoveForward(6)
        listOfCars[2].tryToMoveForward(4)

        val cars = Cars(listOfCars)

        assertThat(cars.getProgressOfCars()).isEqualTo(listOf(1,1,0))
    }
}