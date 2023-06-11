package racingcar

import racingcar.controller.RacingCarGameController
import racingcar.domain.RacingCarGame
import racingcar.view.RacingCarGameInputView
import racingcar.view.RacingCarGameResultView

fun main() {
    val racingCarGameController = RacingCarGameController(
        racingCarGame = RacingCarGame(),
        racingCarGameInputView = RacingCarGameInputView(),
        racingCarGameResultView = RacingCarGameResultView(),
    )

    racingCarGameController.gameStart()
}
