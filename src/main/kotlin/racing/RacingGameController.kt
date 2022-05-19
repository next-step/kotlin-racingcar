package racing

import racing.model.RacingGame
import racing.view.InputView
import racing.view.ResultView

class RacingGameController {
    fun start() {
        val gameSetting = InputView.input()
        val racingGame = RacingGame(gameSetting)
        racingGame.race()
        ResultView.display(racingGame.getResults())
    }
}
