package racingcar

import racingcar.ui.InputView
import racingcar.ui.ResultView

fun main() {
    val inputView = InputView()
    val carCount = inputView.inputCarCount()
    val tryCount = inputView.inputTryCount()

    val resultView = ResultView()

    var printCount = 0
    RacingCar(carCount, tryCount) { car ->
        resultView.printCarState(car)
        printCount ++

        if (printCount % carCount == 0 && printCount < (carCount * tryCount)) {
            resultView.printLineSpacing()
        }
    }.start()
}
