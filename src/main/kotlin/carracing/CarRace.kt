package carracing

import carracing.view.ResultView
import kotlin.random.Random

class CarRace(val cars: List<Car>, val numRounds: Int) {

    init {
        require(cars.size >= MIN_NUMBER_OF_CARS) { "Not enough cars to race" }
        require(numRounds > MIN_NUMBER_OF_ROUNDS) { "Select at least one round to start the race" }
    }

    fun startRace() {

        repeat(numRounds) {
            cars.forEach { it.move(random = getRandom()) }
            ResultView.showStatus(cars)
        }
    }

    private fun getRandom() = Random.nextInt(RANDOM_NUMBER_BOUNDARY)

    companion object {
        const val RANDOM_NUMBER_BOUNDARY = 10
        const val MIN_NUMBER_OF_CARS = 2
        const val MIN_NUMBER_OF_ROUNDS = 0
    }
}
