import racingcar.domain.CarNames
import racingcar.domain.GameManager
import racingcar.etc.InputView
import racingcar.etc.StringAsNumber

fun main() {
    val carNames = CarNames(InputView.carNames())
    val numberOfRaces = StringAsNumber(InputView.numberOfRaces())
    val gameManager = GameManager(carNames, numberOfRaces.toInt())
    gameManager.racing()
}
