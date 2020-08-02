package racingcar.model

class Participant(private val racingCars: List<Car>) {

    private val _movingDistanceHistory = mutableListOf<Int>()
    val movingDistanceHistory: List<Int> get() = _movingDistanceHistory

    fun play(tryCount: Int) {
        repeat(tryCount) {
            racingCars.forEach { car ->
                car.move(MOVING_CONDITION_RANGE.random())
                _movingDistanceHistory.add(car.movingDistance)
            }
        }
    }

    fun findWinner(): List<Car> {
        val farthestDistance = findFarthestCar().movingDistance
        return racingCars.filter { it.movingDistance == farthestDistance }
    }

    private fun findFarthestCar() = racingCars.maxBy { it.movingDistance } ?: racingCars[0]

    companion object {
        private val MOVING_CONDITION_RANGE = 0..9
    }
}
