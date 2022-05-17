package racingcar

import racingcar.controller.RacingController
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    ResultView.printResult(
        RacingController.startGame(
            InputView.getCarNames(),
            InputView.getNumberOfRaces()
        )
    )
}
