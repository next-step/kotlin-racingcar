package racingcar

import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val inputView = InputView()
    val resultView = ResultView()

    val racingCarController = RacingCarController(inputView, resultView)
    racingCarController.start()
}
