package racingcar.game

import racingcar.game.domain.Game
import racingcar.game.ui.InputConsole
import racingcar.game.ui.Screen

fun main() {
    val carNameReader = { readLine() }
    val numOfGameReader = { readLine() }
    val gameParameter = InputConsole(carNameReader, numOfGameReader).run()
    val result = Game.start(gameParameter)
    Screen.show(result)
}
