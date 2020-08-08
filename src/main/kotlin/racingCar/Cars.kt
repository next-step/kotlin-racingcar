package racingCar

import kotlin.random.Random

class Cars(carNames: List<String>) {
    val cars = (carNames.indices).map { Car(carNames[it]) }

    fun moveCars() {
        cars.forEach { it.move(getRandomNumbers()) }
    }

    fun findWinners(): List<Car> {
        val winnerDistance = cars.map { it.distance }.max() ?: return listOf()
        return cars.filter { it.isEqualDistance(winnerDistance) }
    }

    private fun getRandomNumbers(): Int {
        return Random.nextInt(MIN_NUMBER, MAX_NUMBER)
    }

    companion object {
        private const val MIN_NUMBER = 0
        private const val MAX_NUMBER = 10
    }
}
