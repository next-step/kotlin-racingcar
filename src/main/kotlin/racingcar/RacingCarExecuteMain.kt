package racingcar

import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()
    val controller = Controller(inputView, resultView)

    controller.startRacing()
}
