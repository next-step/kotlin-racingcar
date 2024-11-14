package carracing.app

import carracing.domain.Car
import carracing.domain.Race
import carracing.strategy.DefaultRandomGenerator
import carracing.ui.InputView
import carracing.ui.ResultView

fun main() {
    val numberOfCars = InputView.getNumberOfCars()
    val numberOfAttempts = InputView.getNumberOfAttempts()
    val race = Race(List(numberOfCars) { Car() }, numberOfAttempts, DefaultRandomGenerator())

    ResultView.printStartMessage()
    race.start()
}
