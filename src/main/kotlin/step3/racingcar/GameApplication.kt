package step3.racingcar

import step3.racingcar.controller.RacingGameController
import step3.racingcar.service.RacingGameService

fun main(args: Array<String>) {
    val racingGameController = RacingGameController(RacingGameService())
    racingGameController.run()
}
