package racing

import racing.controller.RandomNumberInput
import racing.domain.RacingGame
import racing.view.InputRuleView

class RacingGameApp {
    private val ruleView = InputRuleView()

    // input info
    private val gameInfo = ruleView.inputGameInfo()

    fun startGame() {
        val racingGame = RacingGame(gameInfo, RandomNumberInput())
        racingGame.startGame()
    }
}

fun main() {
    val game = RacingGameApp()

    game.startGame()
}
