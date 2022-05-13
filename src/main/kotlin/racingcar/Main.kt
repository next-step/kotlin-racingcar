package racingcar

import racingcar.controller.NumberAndStepsGameBuilder
import racingcar.controller.RacingGameController
import racingcar.view.input.NumberAndStepsInputView
import racingcar.view.output.DefaultResultView

fun main() {

    val gameController = RacingGameController(
        inputView = NumberAndStepsInputView(),
        gameBuilder = NumberAndStepsGameBuilder(),
        resultView = DefaultResultView()
    )

    gameController.executeGame()
}
