package racing

import racing.application.RacingGame
import racing.ui.InputView

fun main() {
    val numberOfCar = InputView.getNumberOfCar()
    val tryCount = InputView.getTryCount()

    RacingGame(tryCount = tryCount, numberOfCar = numberOfCar).runRace()
}
