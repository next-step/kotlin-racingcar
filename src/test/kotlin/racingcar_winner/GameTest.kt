package racingcar_winner

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar_winner.model.Car
import racingcar_winner.model.Cars
import racingcar_winner.model.GameManager

private val PHOBI = 0
private val JOHN = 1
private val JAMES = 2


class RefereeTest {

    private val listOfCars = listOf<Car>(
        Car("Phobi"), Car("John"), Car("James")
    )

    @Test
    fun `공동승자가 있는경우 모두 승자로 출력되는지 확인`() {
        listOfCars[PHOBI].tryToMoveForward(5)
        listOfCars[PHOBI].tryToMoveForward(5)
        listOfCars[JOHN].tryToMoveForward(5)
        listOfCars[JOHN].tryToMoveForward(5)

        // [현재 Progress] Phobi: 2, John: 2, James: 0
        val cars = Cars(listOfCars)
        val gameManager = GameManager(cars)
        val highScore = gameManager.getHighScore()
        val winners = gameManager.getWinners(highScore)

        assertThat(winners).isEqualTo(listOf("Phobi", "John"))
    }

    @Test
    fun `공동승자가 없는경우 승자가 출력되는지 확인`() {
        listOfCars[PHOBI].tryToMoveForward(5)
        listOfCars[PHOBI].tryToMoveForward(5)

        // [현재 Progress] Phobi: 2, John: 0, James: 0
        val cars = Cars(listOfCars)
        val gameManager = GameManager(cars)
        val highScore = gameManager.getHighScore()
        val winners = gameManager.getWinners(highScore)

        assertThat(winners).isEqualTo(listOf("Phobi"))
    }

    @Test
    fun `차들이 움직였을 때의 Progress 확인`() {
        listOfCars[0].tryToMoveForward(5)
        listOfCars[1].tryToMoveForward(6)
        listOfCars[2].tryToMoveForward(7)

        val cars = Cars(listOfCars)
        val gameManager = GameManager(cars)
        val progressList = gameManager.getProgressOfCars()

        assertThat(progressList).isEqualTo(listOf("Phobi : -", "John : -", "James : -"))
    }

    @Test
    fun `차들이 움직이지 않았을 때의 Progress 확인`() {
        listOfCars[0].tryToMoveForward(1)
        listOfCars[1].tryToMoveForward(2)
        listOfCars[2].tryToMoveForward(3)

        val cars = Cars(listOfCars)
        val gameManager = GameManager(cars)
        val progressList = gameManager.getProgressOfCars()

        assertThat(progressList).isEqualTo(listOf("Phobi : ", "John : ", "James : "))
    }
}