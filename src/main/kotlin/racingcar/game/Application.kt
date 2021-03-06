package racingcar.game

import racingcar.game.ui.InputConsole
import racingcar.game.ui.Screen

fun main() {
    val game = InputConsole().run()
    val result = game.start()
    Screen.show(result)
}
