package racingcar

import racingcar.controller.RacingCarController
import racingcar.view.ConsoleInput
import racingcar.view.ConsoleOutput

fun main() {
    val input = ConsoleInput()
    val output = ConsoleOutput()

    RacingCarController(input, output).race()
}
