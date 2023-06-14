package racingcar

import racingcar.controller.RacingGameController
import racingcar.service.RacingGameService

fun main() {
    val racingGameController = RacingGameController(RacingGameService())
    racingGameController.run()
}
