package racingcar

import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()

    val inputCarNames = inputView.inputCarNames()
    val tryCount = inputView.inputTryCount()
    val controller = Controller(inputCarNames, tryCount)

    controller.racingStart()
    val carNames = controller.carNames()

    for (i in 0 until tryCount) {
        carNames.forEach { carName ->
            resultView.printCarName(carName)
            resultView.printCarMove(controller.moveInfo(carName)[i])
        }

        resultView.printLineSpacing()
    }

    resultView.printWinningCars(controller.winningCarNames())
}
