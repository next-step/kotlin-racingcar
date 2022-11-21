package racingcar

import racingcar.move.ForwardStrategy
import racingcar.ui.InputView
import racingcar.ui.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()

    val carCount = inputView.inputCarCount()
    val tryCount = inputView.inputTryCount()

    val racingHistory = RacingCar(carCount, tryCount).start(ForwardStrategy.CarForward)

    for (i in 0 until tryCount) {
        racingHistory.keys.forEach { car ->
            resultView.printCarMove(racingHistory[car]!![i])
        }

        if (i < tryCount - 1) {
            resultView.printLineSpacing()
        }
    }
}
