package racingcar

import racingcar.controller.RacingCarController
import racingcar.domain.RandomStrategy
import racingcar.view.ConsoleInput
import racingcar.view.ConsoleOutput

fun main() {
    val input = ConsoleInput()
    val output = ConsoleOutput()
    val moveStrategy = RandomStrategy()
    RacingCarController(input, output, moveStrategy).race()
}
