package racing.v2.domain

class CarGame(
    private val cars: List<Car>,
    private var tryCount: Int,
    private val randomGenerator: RandomGenerator
) {

    fun startRound() {
        moveAllCarsOnce()
        tryCount--
    }

    private fun moveAllCarsOnce() {
        cars.forEach {
            it.moveForward(CarDrivingPolicy, randomGenerator.nextInt(10))
        }
    }

    fun findWinners(): List<Car> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
    }

    fun hasMoreRounds(): Boolean = tryCount > 0
}
