package racingcar

import racingcar.controller.CarNamesAndStepsGameBuilder
import racingcar.controller.RacingGameController
import racingcar.view.input.CarNameAndStepsInputView
import racingcar.view.output.DefaultResultView

fun main() {

    val gameController = RacingGameController(
        inputView = CarNameAndStepsInputView(),
        gameBuilder = CarNamesAndStepsGameBuilder(),
        resultView = DefaultResultView()
    )

    gameController.executeGame()
}
