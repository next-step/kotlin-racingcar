package carGame

import carGame.domain.CarGame
import carGame.view.InputView
import carGame.view.OutputView

fun main() {
    val carNames = InputView.getCarNames()
    val tryCount = InputView.getTryCount()

    val carGame = CarGame(Configuration.moveStrategy())
    val result = carGame.play(carNames = carNames, tryCount = tryCount)

    OutputView.printHistory(result.history)
    OutputView.printWinner(result.getWinners())
}
