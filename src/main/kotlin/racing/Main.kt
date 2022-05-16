package racing

import racing.car.CarRegistration
import racing.common.CarRaceProperty
import racing.race.CarRace
import racing.utils.RandomNumberGenerator
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
    for (round in CarRaceProperty.ROUND_START..carRaceProperty.roundSize) {
        carRaceProperty.cars
            .filter { it.canMoveForward(RandomNumberGenerator.getRandomNumber()) }
            .map { carRace.moveCarPosition(it) }

        resultView.printResultByRound(round)
    }
}
