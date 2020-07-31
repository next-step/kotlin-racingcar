package racingcar.model

class Participant(
    racingCarNames: List<String>,
    tryCount: Int
) {

    private val cars = racingCarNames.map(::Car)
    val movingDistanceHistory = Array(cars.size) {
        Array(tryCount) {
            cars[0].movingDistance
        }
    }
    private var currentTriedCount = 0

    fun play() {
        cars.forEachIndexed { index, car ->
            car.move(MOVING_CONDITION_RANGE.random())
            movingDistanceHistory[index][currentTriedCount++] = car.movingDistance
        }
    }

    companion object {
        private val MOVING_CONDITION_RANGE = 0..9
    }
}
