package racingcar

import racingcar.domain.RacingGame
import racingcar.input.InputConsole
import racingcar.output.OutputConsole

fun main() {
    RacingGame(InputConsole(), OutputConsole()).start()
}
