package racingcar

import racingcar.controller.RacingGameController
import racingcar.infrastructure.RandomNumberGenerator
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    val racingGameController = RacingGameController(InputView(), OutputView(), RandomNumberGenerator())
    racingGameController.run()
    racingGameController.announceResult()
    racingGameController.announceWinner()
}
