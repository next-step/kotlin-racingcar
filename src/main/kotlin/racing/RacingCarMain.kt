package racing

import racing.domain.MovementChecker
import racing.domain.RacingGame
import racing.ui.InputView
import racing.ui.ResultView

object RacingCarMain {
    fun run() {
        val racingGameData = InputView.askQuestion()
        val racingGame = RacingGame(racingGameData.carNames, MovementChecker())

        ResultView.printResultNotice()

        repeat(racingGameData.tryCount) {

            racingGame.moveAllCar()
            val cars = racingGame.cars

            ResultView.printAllPosition(cars)
        }
    }
}

fun main() {
    RacingCarMain.run()
}
