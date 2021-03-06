package racing.controller

import racing.domain.MovementChecker
import racing.domain.RacingGame
import racing.ui.InputView
import racing.ui.ResultView

object RacingController {
    fun run() {
        val racingGameData = InputView.askQuestion()

        val racingGame = RacingGame(racingGameData, MovementChecker())
        racingGame.run()

        ResultView.printRacingResult(racingGame)
    }
}
