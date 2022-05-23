package racing

import racing.common.CarRaceProperty
import racing.race.CarRace
import racing.validation.CarRaceValidation
import racing.view.InputView
import racing.view.ResultView

fun main() {
    val inputView = InputView()
    val carNames = inputView.readInCarNames()
    val roundSize = inputView.readInRoundSize()

    val carRaceValidation = CarRaceValidation()
    carRaceValidation.validateCarName(carNames)

    val carRaceProperty = CarRaceProperty(roundSize, carNames)

    val resultView = ResultView(carRaceProperty)
    val carRace = CarRace(carRaceProperty, resultView)
    carRace.start()
}
