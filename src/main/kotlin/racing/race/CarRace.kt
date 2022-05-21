package racing.race

import racing.car.Car
import racing.common.CarRaceProperty
import racing.utils.RandomNumberGenerator.getRandomNumber
import racing.view.ResultView

class CarRace(
    private val carRaceProperty: CarRaceProperty,
    private val resultView: ResultView
) {
    fun start() {
        for (round in CarRaceProperty.ROUND_START..carRaceProperty.roundSize) {
            raceByRound()
            resultView.printResultByRound(round)
        }

        val winnerJudge = WinnerJudge(carRaceProperty)
        resultView.printWinner(winnerJudge.getWinnerCarNames())
    }

    private fun raceByRound() {
        carRaceProperty.cars
            .filter { it.canMoveForward(getRandomNumber()) }
            .map { moveCarPosition(it) }
    }

    fun moveCarPosition(car: Car) {
        moveForward(car)
    }

    private fun moveForward(car: Car) = car.setMoveCount(1)
}
