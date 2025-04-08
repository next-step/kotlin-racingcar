package carracing

import carracing.RandomNumberGenerator.getRandom
import carracing.view.ResultView

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
        ResultView.displayWinners(winners = getWinners())
    }

     fun getWinners(): List<Car> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
    }

    companion object {
        const val MIN_NUMBER_OF_CARS = 2
        const val MIN_NUMBER_OF_ROUNDS = 0
    }
}
