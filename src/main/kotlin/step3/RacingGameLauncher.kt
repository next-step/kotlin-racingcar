package step3

import step3.model.RacingGame
import step3.ui.InputView
import step3.ui.ResultView

object RacingGameLauncher {
    fun start() {
        val gameSetting = InputView.input()
        val result = RacingGame(gameSetting).race()
        ResultView.display(result)
    }
}

fun main() {
    RacingGameLauncher.start()
}
