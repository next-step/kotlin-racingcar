package step3

import step3.domain.CarGame
import step3.view.InputView
import step3.view.OutputView

fun main() {
    val carCount = InputView.getCarCount()
    val tryCount = InputView.getTryCount()

    val carGame = CarGame(Configuration.moveStrategy())
    val result = carGame.play(carCount = carCount, tryCount = tryCount)

    OutputView.printResult(result)
}
