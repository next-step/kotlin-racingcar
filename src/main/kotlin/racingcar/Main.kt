package racingcar

import racingcar.controller.RacingGameController

fun main() {
    val controller = RacingGameController()
    controller.setUpGame()
    controller.race()
}
