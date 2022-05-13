package step3

import step3.car.CarRegistration
import step3.common.CarRaceProperty
import step3.race.CarRace
import step3.utils.RandomNumberGenerator
import step3.view.InputView
import step3.view.ResultView

fun main() {
    val carRaceProperty = CarRaceProperty()
    val inputView = InputView(carRaceProperty)
    inputView.readInRoundSize()
    inputView.readInCarSize()

    val carRegistration = CarRegistration(carRaceProperty)
    carRegistration.initCars()

    val carRace = CarRace()
    val resultView = ResultView(carRaceProperty)
    for (round in CarRaceProperty.ROUND_START..carRaceProperty.roundSize) {
        carRaceProperty.cars
            .map {
                carRace.moveCarPosition(it, it.canMoveForward(RandomNumberGenerator.getRandomNumber()))
            }

        resultView.printResultByRound(round)
    }
}
