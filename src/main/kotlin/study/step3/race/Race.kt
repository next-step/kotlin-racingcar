package study.step3.race

import study.step3.domain.Car
import kotlin.random.Random

class Race(
    private val inputView: InputView,
    private val random: Random
) {

    val carCount = inputView.carCount()
    val carStorage = Array(carCount) { Car() }

    companion object {
        private const val RANDOM_BOUND = 10
        private const val FORWARD_THRESHOLD = 3
    }

    fun startRace() {
        val raceCount = inputView.raceTryCnt()
        val drawView = DrawView(raceCount)

        for (raceIdx in 1..raceCount) {
            moveCarsIfPossible()
            val carResponses = carStorage.map(Car::toResponseByCar)
            drawView.drawCarState(carResponses, raceIdx)
        }
    }

    private fun moveCarsIfPossible() {
        for (car in carStorage) {
            val randomNumber = random.nextInt(RANDOM_BOUND)
            if (randomNumber > FORWARD_THRESHOLD) car.move()
        }
    }
}
