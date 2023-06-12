package racingcar

import racingcar.io.InputView
import racingcar.racing.RacingGame

fun main() {
    val input = InputView().getInput()
    RacingGame(input).start()
}
