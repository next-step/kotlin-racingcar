package step3.race

import step3.CarRaceConst.ROUND_START
import step3.CarRaceConst.car
import step3.CarRaceConst.roundSize
import step3.car.Car

class RaceService {

    fun runRacingByRound() {
        for (round in ROUND_START..roundSize) {
            car.map { move(it.value) }
        }
    }

    private fun move(car: Car) {
        car.moveCount++
    }
}
