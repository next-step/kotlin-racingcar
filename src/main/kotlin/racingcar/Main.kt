package racingcar

import racingcar.domain.RacingGame
import racingcar.input.InputConsole
import racingcar.output.OutputConsole

fun main() {
    val racingGame = RacingGame(InputConsole(), OutputConsole())

    racingGame.start()
}
