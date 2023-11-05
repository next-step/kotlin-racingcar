package racing.v2.domain

import kotlin.random.Random

class CarGame(private val cars: List<Car>, private var tryCount: Int) {

    fun startRound() {
        moveAllCarsOnce()
        tryCount--
    }

    private fun moveAllCarsOnce() {
        cars.forEach {
            it.moveForward(CarDrivingPolicy, Random.nextInt(10))
        }
    }

    fun findWinners(): List<Car> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
    }

    fun hasMoreRounds(): Boolean = tryCount > 0
}
