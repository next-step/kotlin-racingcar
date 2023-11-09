package racing.v2.domain

class CarGame(
    private val cars: List<Car>,
    private var tryCount: Int,
    private val drivingPolicy: DrivingPolicy = CarDrivingPolicy()
) {
    fun startRound() {
        moveAllCarsOnce()
        tryCount--
    }

    private fun moveAllCarsOnce() {
        cars.forEach {
            it.moveForward(drivingPolicy)
        }
    }

    fun findWinners(): List<Car> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
    }

    fun hasMoreRounds(): Boolean = tryCount > 0
}
