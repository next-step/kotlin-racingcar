package racingcar

import racingcar.controller.CarNamesAndStepsGameBuilder
import racingcar.controller.RacingGameController
import racingcar.view.input.CarNameAndStepsInputView
import racingcar.view.output.WinnerResultView

fun main() {

    val gameController = RacingGameController(
        inputView = CarNameAndStepsInputView(),
        gameBuilder = CarNamesAndStepsGameBuilder(),
        resultView = WinnerResultView()
    )

    gameController.executeGame()
}
