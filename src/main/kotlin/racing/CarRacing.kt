package racing

import kotlin.random.Random

class CarRacing private constructor(carNames: List<String>) {
    private val cars = carNames.map { Car(it) }

    private fun race(tryCount: Int): List<List<Int>> {
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

    private fun List<Car>.recordRacingResultPerRound() = map { it.position }

    companion object {
        fun race(carNames: List<String>, tryCount: Int): List<List<Int>> {
            return CarRacing(carNames).race(tryCount)
        }
    }
}
