package racingcar.model

class RacingGame(val racingCars: List<Car>) {

    private val _movingDistanceHistory = mutableListOf<Int>()
    val movingDistanceHistory: List<Int> get() = _movingDistanceHistory

    fun play(tryCount: Int) {
        repeat(tryCount) {
            tryMove()
        }
    }

    private fun tryMove() {
        racingCars.forEach { car ->
            car.move(MOVING_CONDITION_RANGE.random())
            _movingDistanceHistory.add(car.movingDistance)
        }
    }

    companion object {
        private val MOVING_CONDITION_RANGE = 0..9
    }
}
