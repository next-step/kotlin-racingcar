package carracing

import carracing.RandomNumberGenerator.getRandom

typealias RaceHistory = List<List<Car>>

class CarRace(val cars: List<Car>, val numRounds: Int) {

    init {
        require(cars.size >= MIN_NUMBER_OF_CARS) { "Not enough cars to race" }
        require(numRounds > MIN_NUMBER_OF_ROUNDS) { "Select at least one round to start the race" }
    }

    private val raceHistory = mutableListOf<List<Car>>()
    fun startRace(): RaceHistory {
        repeat(numRounds) {
            cars.forEach { it.move(random = getRandom()) }
            raceHistory.add(cars.map { Car(it.name, it.position) })
        }
        return raceHistory
    }

    fun getWinners(): List<Car> {
        val maxPosition = cars.maxOf { it.position }
        cars.forEach { it.setAsWinner(maxPosition) }
        return cars.filter { it.isWinner }
    }

    companion object {
        const val MIN_NUMBER_OF_CARS = 2
        const val MIN_NUMBER_OF_ROUNDS = 0
    }
}
