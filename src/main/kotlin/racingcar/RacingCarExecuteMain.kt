package racingcar

import racingcar.ui.InputView
import racingcar.ui.ResultView

fun main() {
    val inputView = InputView()
    val carCount = inputView.inputCarCount()
    val tryCount = inputView.inputTryCount()

    RacingCar(carCount, tryCount).start().apply {
        val resultView = ResultView()

        for (i in 0 until tryCount) {
            this.forEach { car ->
                resultView.printCarMove(car, i)
            }

            if (i < tryCount - 1) {
                resultView.printLineSpacing()
            }
        }
    }
}
