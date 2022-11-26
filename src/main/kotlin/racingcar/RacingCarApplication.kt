package racingcar

import racingcar.domain.RandomStrategy
import racingcar.`in`.RacingCarController
import racingcar.view.ConsoleInput
import racingcar.view.ConsoleOutput

fun main() {
    val input = ConsoleInput()
    val output = ConsoleOutput()
    val moveStrategy = RandomStrategy()

    RacingCarController(input, output, moveStrategy).race()
}
