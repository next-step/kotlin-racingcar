package racingcar.game

import racingcar.game.domain.Game
import racingcar.game.view.InputConsole
import racingcar.game.view.Screen

fun main() {
    val gameParameter = InputConsole().run()
    val result = Game.start(gameParameter)
    Screen.show(result)
}
