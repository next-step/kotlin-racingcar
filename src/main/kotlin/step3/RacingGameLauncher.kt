package step3

import step3.ui.InputView
import step3.ui.ResultView

object RacingGameLauncher {
    fun start() {
        val gameSetting = InputView.input()
        val gameResult = RacingGame(gameSetting).racing()
        ResultView.display(gameResult)
    }
}

fun main() {
    RacingGameLauncher.start()
}
