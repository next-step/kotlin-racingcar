import racingcar.ui.GameManager
import racingcar.ui.InputView
import racingcar.model.StringAsNumber

fun main() {
    val numberOfCars = StringAsNumber(InputView.numberOfCars())
    val numberOfRaces = StringAsNumber(InputView.numberOfRaces())
    val gameManager = GameManager(numberOfCars.toInt(), numberOfRaces.toInt())
    gameManager.racing()
}
