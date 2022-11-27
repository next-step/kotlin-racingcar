package racing

import racing.domain.Cars
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

        ResultView.printResult()
        while (racingGame.isRacing()) {
            racingGame.race()
            ResultView.print(racingGame.positions())
        }
    }
}
