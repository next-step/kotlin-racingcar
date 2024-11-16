package racingcar

import racingcar.controller.RacingGameController
import racingcar.infrastructure.RandomNumberGenerator
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val racingGameController = RacingGameController(InputView(), ResultView(), RandomNumberGenerator())
    racingGameController.run()
    racingGameController.announceWinner()
}
