package carracing

import kotlin.random.Random

class CarRace(val numCars: Int, val numRounds: Int) {
    val cars = List(numCars) { Car(name = "Car ${it + 1}") }
    fun startRace() {
        require(cars.size >= 2) { "Not enough cars to race" }
        require(numRounds > 0) { "Select at least one round to start the race" }
        repeat(numRounds) {
            cars.forEach { it.move(random = getRandom()) }
            ResultView.showStatus(cars)
        }
    }

    private fun getRandom() = Random.nextInt(RANDOM_NUMBER_BOUNDARY)

    companion object {
        const val RANDOM_NUMBER_BOUNDARY = 10
    }
}
