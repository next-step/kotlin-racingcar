package racing

import racing.common.CarRaceProperty
import racing.race.CarRace
import racing.view.InputView
import racing.view.ResultView

fun main() {
    val inputView = InputView()
    val carNames = inputView.readInCarNames()
    val roundSize = inputView.readInRoundSize()
    val carRaceProperty = CarRaceProperty(roundSize, carNames)

    val carRace = CarRace()
    val resultView = ResultView(carRaceProperty)
    carRace.start(carRaceProperty, resultView)
}
