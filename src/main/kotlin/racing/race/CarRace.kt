package racing.race

import racing.car.Car
import racing.common.CarRaceProperty
import racing.utils.RandomNumberGenerator.getRandomNumber
import racing.view.ResultView

class CarRace {
    fun start(carRaceProperty: CarRaceProperty, resultView: ResultView) {
        for (round in CarRaceProperty.ROUND_START..carRaceProperty.roundSize) {
            raceByRound(carRaceProperty)
            resultView.printResultByRound(round)
        }

        resultView.printWinner()
    }

    private fun raceByRound(carRaceProperty: CarRaceProperty) {
        carRaceProperty.cars
            .filter { it.canMoveForward(getRandomNumber()) }
            .map { moveCarPosition(it) }
    }

    fun moveCarPosition(car: Car) {
        moveForward(car)
    }

    private fun moveForward(car: Car) = car.setMoveCount(1)
}
