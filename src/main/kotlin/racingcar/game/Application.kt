package racingcar.game

import racingcar.game.domain.Game
import racingcar.game.domain.generateMoveCondition
import racingcar.game.ui.InputConsole
import racingcar.game.ui.Screen

fun main() {
    val carNameReader = { readLine() }
    val numOfGameReader = { readLine() }
    val gameParameter = InputConsole(carNameReader, numOfGameReader).run()

    val moveCondition = ::generateMoveCondition

    val result = Game(gameParameter, moveCondition).start()
    Screen.show(result)
}
