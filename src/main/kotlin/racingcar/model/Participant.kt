package racingcar.model

class Participant(private val racingCars: List<Car>, tryCount: Int) {

    val movingDistanceHistory = Array(racingCars.size) {
        Array(tryCount) {
            racingCars[0].movingDistance
        }
    }

    fun play(tryCount: Int) {
        racingCars.forEachIndexed { index, car ->
            car.move(MOVING_CONDITION_RANGE.random())
            movingDistanceHistory[index][tryCount] = car.movingDistance
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
