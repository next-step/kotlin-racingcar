package racing

import racing.domain.Cars
import racing.ui.InputView
import racing.ui.ResultView

fun main() {
    RacingApplication.run()
}

object RacingApplication {

    fun run() {
        val numberOfCars = InputView.inputNumberOfCars()
        val countOfTry = InputView.inputCountOfTry()
        val racingGame = RacingGame(Cars.create(numberOfCars), countOfTry)

        ResultView.printResult()
        while (racingGame.isRacing()) {
            racingGame.race()
            ResultView.print(racingGame.positions())
        }
    }
}
