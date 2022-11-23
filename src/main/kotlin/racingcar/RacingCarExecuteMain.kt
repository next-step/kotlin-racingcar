package racingcar

import racingcar.ui.InputView
import racingcar.ui.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()

    val carNames = inputView.inputCarNames()
    val tryCount = inputView.inputTryCount()

    val racingHistory = RacingCar(carNames, tryCount).start(ForwardStrategy.CarForward)

    for (i in 0 until tryCount) {
        racingHistory.keys.forEach { car ->
            resultView.printCarName(car.name)
            resultView.printCarMove(racingHistory[car]!![i])
        }

        if (i < tryCount - 1) {
            resultView.printLineSpacing()
        }
    }
}
