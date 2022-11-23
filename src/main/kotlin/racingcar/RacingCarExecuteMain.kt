package racingcar

import racingcar.ui.InputView
import racingcar.ui.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()

    val carNames = inputView.inputCarNames()
    val tryCount = inputView.inputTryCount()
    val racingCar = RacingCar(carNames, tryCount)

    val racingHistory = racingCar.start(ForwardStrategy.DefaultForward)
    val winningCarNames = racingCar.getWinningCarNames()

    for (i in 0 until tryCount) {
        racingHistory.keys.forEach { car ->
            resultView.printCarName(car.name)
            resultView.printCarMove(racingHistory[car]!![i])
        }

        if (i < tryCount - 1) {
            resultView.printLineSpacing()
        }
    }

    resultView.printWinningCars(winningCarNames)
}
