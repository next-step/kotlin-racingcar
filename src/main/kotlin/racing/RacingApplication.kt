package racing

import racing.domain.Cars
import racing.domain.Winners
import racing.ui.InputView
import racing.ui.ResultView

fun main() {
    RacingApplication.run()
}

object RacingApplication {

    fun run() {
        val namesOfCars = InputView.inputNamesOfCars()
        val countOfTry = InputView.inputCountOfTry()
        val racingGame = RacingGame(Cars.create(namesOfCars), countOfTry)

        printRacingCars(racingGame)
        printWinners(racingGame)
    }

    private fun printRacingCars(racingGame: RacingGame) {
        ResultView.printResult()
        while (racingGame.isPlaying()) {
            racingGame.race()
            ResultView.print(racingGame.cars())
        }
    }

    private fun printWinners(racingGame: RacingGame) {
        val winners = Winners(racingGame.cars())
        ResultView.printWinners(winners.names())
    }
}
