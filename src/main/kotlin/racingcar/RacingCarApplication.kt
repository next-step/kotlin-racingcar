package racingcar

import racingcar.controller.RacingController
import racingcar.domain.Record
import racingcar.view.InputView

fun main() {
    val racingController = RacingController(InputView(), Record())
    racingController.startGame()
}
