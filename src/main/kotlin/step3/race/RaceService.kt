package step3.race

import step3.CarRaceConst.ROUND_START
import step3.CarRaceConst.car
import step3.CarRaceConst.roundSize
import step3.car.Car
import step3.utils.NumberUtils.Companion.getRandomNumber
import step3.view.ResultView

class RaceService {
    private val resultView = ResultView()
    fun runRacingByRound() {
        for (round in ROUND_START..roundSize) {
            car.filter { canBeMove(getRandomNumber()) }.map { move(it.value) }
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
