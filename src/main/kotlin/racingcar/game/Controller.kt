package racingcar.game

import racingcar.game.domain.Game
import racingcar.game.view.InputConsole
import racingcar.game.view.Screen

class Controller {
    companion object {
        fun gameStart() {
            val gameParameter = InputConsole.run()
            val result = Game.start(gameParameter)
            val winners = Game.findWinners(result)
            Screen.show(result, winners)
        }
    }
}
