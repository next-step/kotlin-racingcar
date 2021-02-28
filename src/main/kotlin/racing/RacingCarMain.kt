package racing

import racing.components.MovementChecker
import racing.components.RacingGame
import racing.ui.InputView
import racing.ui.ResultView

object RacingCarMain {
    fun run() {
        val racingGameData = InputView.askQuestion()
        val racingGame = RacingGame(racingGameData.carCount, MovementChecker())

        ResultView.printResultNotice()

        for (i in 1..racingGameData.tryCount) {

            racingGame.moveAllCar()
            val carPositions = racingGame.getCarPositions()

            ResultView.printAllPosition(carPositions)
        }
    }
}

fun main() {
    RacingCarMain.run()
}
