package study.racinggame.race

import study.racinggame.domain.Car
import study.racinggame.domain.CarResponse
import kotlin.random.Random

class Race(
    private val inputView: InputView,
    private val random: Random
) {

    private val carCount = inputView.carCount()
    private val carStorage = Array(carCount) { Car() }

    fun startRace() {
        val drawView = DrawView()

        for (raceIdx in 1..inputView.raceTryCnt()) {
            moveCarsIfPossible()
            val carResponses = carStorage.map(this::toResponseByCar)
            drawView.drawCarState(carResponses)
        }
    }

    fun carStorage() = carStorage

    private fun moveCarsIfPossible() {
        for (car in carStorage) {
            car.moveForward(random.nextInt(RANDOM_BOUND))
        }
    }

    private fun toResponseByCar(each: Car): CarResponse {
        return CarResponse(each.position)
    }

    companion object {
        private const val RANDOM_BOUND = 10
    }
}
