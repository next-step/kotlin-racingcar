package racingcar

import racingcar.controller.CarNamesAndStepsGameBuilder
import racingcar.controller.RacingGameController
import racingcar.view.input.CarNamesAndStepsInputView
import racingcar.view.output.WinnerResultView

fun main() {

    val gameController = RacingGameController(
        inputView = CarNamesAndStepsInputView(),
        gameBuilder = CarNamesAndStepsGameBuilder(),
        resultView = WinnerResultView()
    )

    gameController.executeGame()
}
