package racing

import racing.application.RacingGame
import racing.ui.InputView

fun main() {
    val numberOfCars = InputView.getNumberOfCars()
    val tryCount = InputView.getTryCounts()

    RacingGame(tryCount = tryCount, numberOfCar = numberOfCars).runRace()
}