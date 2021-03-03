package racingcar_winner

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar_winner.model.Car
import racingcar_winner.model.Cars

private val PHOBI = 0
private val JOHN = 1
private val JAMES = 2


class RefereeTest {

    private val listOfCars = listOf<Car>(
        Car("Phobi"), Car("John"), Car("James")
    )

    @Test
    fun `게임의 승자 확인(동점자가 있는경우)`() {
        listOfCars[PHOBI].tryToMoveForward(5)
        listOfCars[PHOBI].tryToMoveForward(5)
        listOfCars[JOHN].tryToMoveForward(5)
        listOfCars[JOHN].tryToMoveForward(5)

        // [현재 Progress] Phobi: 2, John: 2, James: 0
        val cars = Cars(listOfCars)
        val winners = cars.getWinners()

        assertThat(winners).isEqualTo(listOf("Phobi", "John"))
    }

    @Test
    fun `게임의 승자 확인(동점자가 없는경우)`() {
        listOfCars[PHOBI].tryToMoveForward(5)
        listOfCars[PHOBI].tryToMoveForward(5)

        // [현재 Progress] Phobi: 2, John: 0, James: 0
        val cars = Cars(listOfCars)
        val winners = cars.getWinners()

        assertThat(winners).isEqualTo(listOf("Phobi"))
    }
}