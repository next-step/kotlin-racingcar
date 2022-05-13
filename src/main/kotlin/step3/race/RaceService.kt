package step3.race

import step3.car.Car
import step3.common.CarRaceProperty
import step3.utils.RandomNumberGenerator.getRandomNumber
import step3.view.ResultView

class RaceService(private val carRaceProperty: CarRaceProperty) {
    private val resultView = ResultView(carRaceProperty)
    fun runRacingByRound() {

        for (round in CarRaceProperty.ROUND_START..carRaceProperty.roundSize) {
            carRaceProperty.cars
                .filter { canBeMove(getRandomNumber()) }
                .map { move(it) }

            resultView.printResultByRound(round)
        }
    }

    fun move(car: Car) {
        car.moveCount++
    }

    fun canBeMove(number: Int) = number >= MOVE_CONDITION

    companion object {
        const val MOVE_CONDITION = 4
    }
}
