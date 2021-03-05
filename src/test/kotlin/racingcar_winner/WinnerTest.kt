package racingcar_winner

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import racingcar.ui.OutputView
import racingcar_winner.model.Car
import racingcar_winner.model.Cars
import racingcar_winner.model.Winner

class WinnerTest {

    private val PHOBI = 0
    private val JOHN = 1
    private val JAMES = 2

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
        val winners = Winner(cars).getWinner()

        Assertions.assertThat(winners).isEqualTo(listOf("Phobi", "John"))
    }

    @Test
    fun `공동승자가 없는경우 승자가 출력되는지 확인`() {
        listOfCars[PHOBI].tryToMoveForward(5)
        listOfCars[PHOBI].tryToMoveForward(5)

        // [현재 Progress] Phobi: 2, John: 0, James: 0
        val cars = Cars.makeCars(listOfCars)
        val winners = Winner(cars).getWinner()

        Assertions.assertThat(winners).isEqualTo(listOf("Phobi"))
    }
}
