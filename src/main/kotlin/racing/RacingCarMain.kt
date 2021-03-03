package racing

import racing.domain.MovementChecker
import racing.domain.RacingGame
import racing.ui.InputView
import racing.ui.ResultView

object RacingCarMain {
    fun run() {
        val racingGameData = InputView.askQuestion()
        val racingGame = RacingGame(racingGameData, MovementChecker())

        ResultView.printResultNotice()

        val racingHistory = racingGame.run()

        ResultView.printRacingHistory(racingHistory)
        ResultView.printWinners(racingGame.getWinners())
    }
}

fun main() {
    RacingCarMain.run()
}
