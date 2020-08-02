package racingcar.model

class RacingGame(val racingCars: List<Car>) {

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

    fun getFarthestCarDistance() = racingCars.maxBy { it.movingDistance }?.movingDistance ?: 0

    companion object {
        private val MOVING_CONDITION_RANGE = 0..9
    }
}
