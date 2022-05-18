package racing

import racing.model.RacingGame
import racing.ui.InputView
import racing.ui.ResultView

object RacingGameLauncher {
    fun start() {
        val gameSetting = InputView.input()
        val racingGame = RacingGame(gameSetting)
        racingGame.race()
        ResultView.display(racingGame.record)
    }
}

fun main() {
    RacingGameLauncher.start()
}
