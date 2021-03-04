package racingcar_winner

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.ui.OutputView
import racingcar_winner.model.Car
import racingcar_winner.model.Cars
import racingcar_winner.model.Winner

private val PHOBI = 0
private val JOHN = 1
private val JAMES = 2


class RefereeTest {

    private val winner = Winner()
    private val outputView = OutputView()
    private val listOfCars = listOf<Car>(
        Car.makeCar("Phobi"), Car.makeCar("John"), Car.makeCar("James")
    )


    @Test
    fun `공동승자가 있는경우 모두 승자로 출력되는지 확인`() {
        listOfCars[PHOBI].tryToMoveForward(5)
        listOfCars[PHOBI].tryToMoveForward(5)
        listOfCars[JOHN].tryToMoveForward(5)
        listOfCars[JOHN].tryToMoveForward(5)

        // [현재 Progress] Phobi: 2, John: 2, James: 0
        val cars = Cars.makeCars(listOfCars)
        val winners = winner.getWinner(cars)

        assertThat(winners).isEqualTo(listOf("Phobi", "John"))
    }

    @Test
    fun `공동승자가 없는경우 승자가 출력되는지 확인`() {
        listOfCars[PHOBI].tryToMoveForward(5)
        listOfCars[PHOBI].tryToMoveForward(5)

        // [현재 Progress] Phobi: 2, John: 0, James: 0
        val cars = Cars.makeCars(listOfCars)
        val winners = winner.getWinner(cars)

        assertThat(winners).isEqualTo(listOf("Phobi"))
    }

    @Test
    fun `차들이 움직였을 때의 Progress 확인`() {
        listOfCars[PHOBI].tryToMoveForward(5)
        listOfCars[JOHN].tryToMoveForward(6)
        listOfCars[JAMES].tryToMoveForward(7)

        val progressCars = listOfCars.map { car-> car.progress }

        assertThat(progressCars).isEqualTo(listOf(1,1,1))
    }

    @Test
    fun `차들이 움직이지 않았을 때의 Progress 확인`() {
        listOfCars[PHOBI].tryToMoveForward(1)
        listOfCars[JOHN].tryToMoveForward(2)
        listOfCars[JAMES].tryToMoveForward(3)

        val progressCars = listOfCars.map { car-> car.progress }

        assertThat(progressCars).isEqualTo(listOf(0,0,0))
    }
}