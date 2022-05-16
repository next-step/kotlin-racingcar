package racingcar

import racingcar.controller.RacingController
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val racingController = RacingController()

    racingController.startGame(
        InputView.getCarNames(),
        InputView.getNumberOfRaces()
    ) {
        ResultView.printResult(it)
    }
}
