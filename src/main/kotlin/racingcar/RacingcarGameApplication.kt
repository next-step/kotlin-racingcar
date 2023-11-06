package racingcar

import racingcar.controller.RacingcarGameController
import racingcar.view.RacingcarGameInputView
import racingcar.view.RacingcarGameResultView

fun main() {
    val controller = RacingcarGameController(
        RacingcarGameInputView(),
        RacingcarGameResultView(),
        RacingcarGame()
    )

    controller.startGame()
}
