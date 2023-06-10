package carGame

import carGame.domain.CarGame
import carGame.view.InputView
import carGame.view.OutputView

fun main() {
    val carCount = InputView.getCarCount()
    val tryCount = InputView.getTryCount()

    val carGame = CarGame(Configuration.moveStrategy())
    val result = carGame.play(carCount = carCount, tryCount = tryCount)

    OutputView.printResult(result)
}
