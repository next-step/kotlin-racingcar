import racingcar.etc.GameManager
import racingcar.etc.InputView
import racingcar.etc.StringAsNumber

fun main() {
    val numberOfCars = StringAsNumber(InputView.numberOfCars())
    val numberOfRaces = StringAsNumber(InputView.numberOfRaces())
    val gameManager = GameManager(numberOfCars.toInt(), numberOfRaces.toInt())
    gameManager.racing()
}
