package racing

import racing.car.CarRegistration
import racing.race.CarRace
import racing.view.InputView
import racing.view.ResultView

fun main() {
    val inputView = InputView()
    val roundSize = inputView.readInRoundSize()
    val carSize = inputView.readInCarSize()

    val carRegistration = CarRegistration(roundSize, carSize)
    val carRaceProperty = carRegistration.initCarRaceProperty()

    val carRace = CarRace()
    val resultView = ResultView(carRaceProperty)
    carRace.start(carRaceProperty, resultView)
}
