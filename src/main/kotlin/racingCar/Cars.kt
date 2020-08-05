package racingCar

import kotlin.random.Random

class Cars(numberOfPlayer: Int) {
    val cars = (0 until numberOfPlayer).map { Car() }

    fun moveCars() {
        cars.forEach { it.move(getRandomNumbers()) }
    }

    private fun getRandomNumbers(): Int {
        return Random.nextInt(MIN_NUMBER, MAX_NUMBER)
    }

    companion object {
        private const val MIN_NUMBER = 0
        private const val MAX_NUMBER = 10
    }
}
