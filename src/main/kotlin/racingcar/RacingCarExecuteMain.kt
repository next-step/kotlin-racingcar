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
    val winningCarNames = racingHistory.getWinningCarNames()

    for (i in 0 until tryCount) {
        racingHistory.moveHistory.forEach { moveItem ->
            resultView.printCarName(moveItem.key)
            resultView.printCarMove(moveItem.value[i])
        }

        resultView.printLineSpacing()
    }

    resultView.printWinningCars(winningCarNames)
}
