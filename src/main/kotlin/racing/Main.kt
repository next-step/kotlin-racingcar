package racing

import racing.domain.common.CarRaceProperty
import racing.domain.race.CarRace
import racing.domain.validation.CarRaceValidation
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
