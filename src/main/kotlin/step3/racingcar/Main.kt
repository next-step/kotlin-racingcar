package step3.racingcar

import step3.racingcar.domain.RacingGame
import step3.racingcar.input.InputConsole
import step3.racingcar.output.OutputConsole

fun main() {
    val racingGame = RacingGame(InputConsole(), OutputConsole())

    racingGame.start()
}
