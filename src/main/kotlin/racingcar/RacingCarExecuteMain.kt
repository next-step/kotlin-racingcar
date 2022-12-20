package racingcar

import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()
    //
    // val inputCarNames = inputView.inputCarNames()
    // val tryCount = inputView.inputTryCount()
    // val controller = Controller(inputCarNames, tryCount)
    //
    // controller.startRacing()
    // val carNames = controller.getCarNames()
    //
    // for (i in 0 until tryCount) {
    //     carNames.forEach { carName ->
    //         resultView.printCarName(carName)
    //         resultView.printCarMove(controller.getMoveInfos(carName)[i])
    //     }
    //
    //     resultView.printLineSpacing()
    // }
    //
    // resultView.printWinningCars(controller.getWinningCarNames())

    val controller = Controller(inputView, resultView)
    controller.startRacing(controller.getCarNames(), controller.getTryCount())
}
