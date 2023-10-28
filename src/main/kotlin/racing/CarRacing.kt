package racing

import kotlin.random.Random

class CarRacing private constructor(carNames: List<String>) {
    private val cars = carNames.map { Car(it) }

    private fun race(tryCount: Int): List<List<Car>> {
        return List(tryCount) {
            cars.racePerRound()
            cars.recordRacingResultPerRound()
        }
    }

    private fun List<Car>.racePerRound() {
        forEach { car ->
            car.moveOrStop(random(0..9))
        }
    }

    private fun random(range: IntRange) = Random.nextInt(range.first, range.last)

    private fun List<Car>.recordRacingResultPerRound() = map { it.copy() }

    private fun findWinners(): List<String> {
        val maxPosition = cars.maxBy { it.position }.position
        return cars.filter { car -> car.position == maxPosition }.map { it.name }
    }

    companion object {
        fun race(carNames: List<String>, tryCount: Int): Pair<List<List<Car>>, List<String>> {
            val carRacing = CarRacing(carNames)
            val racingResult = carRacing.race(tryCount)
            val winners = carRacing.findWinners()
            return racingResult to winners
        }
    }
}
