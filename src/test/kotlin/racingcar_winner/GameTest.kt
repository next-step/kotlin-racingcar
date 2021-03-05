package racingcar_winner

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.ui.OutputView
import racingcar_winner.model.Car
import racingcar_winner.model.Winner

class RefereeTest {

    private val PHOBI = 0
    private val JOHN = 1
    private val JAMES = 2

    private val outputView = OutputView()
    private val listOfCars = listOf<Car>(
        Car.makeCar("Phobi"), Car.makeCar("John"), Car.makeCar("James")
    )

    @Test
    fun `차들이 움직였을 때의 Progress 확인`() {
        listOfCars[PHOBI].tryToMoveForward(5)
        listOfCars[JOHN].tryToMoveForward(6)
        listOfCars[JAMES].tryToMoveForward(7)

        val progressCars = listOfCars.map { car -> car.progress }

        assertThat(progressCars).isEqualTo(listOf(1, 1, 1))
    }

    @Test
    fun `차들이 움직이지 않았을 때의 Progress 확인`() {
        listOfCars[PHOBI].tryToMoveForward(1)
        listOfCars[JOHN].tryToMoveForward(2)
        listOfCars[JAMES].tryToMoveForward(3)

        val progressCars = listOfCars.map { car -> car.progress }

        assertThat(progressCars).isEqualTo(listOf(0, 0, 0))
    }
}
