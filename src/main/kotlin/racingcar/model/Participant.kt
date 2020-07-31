package racingcar.model

class Participant(racingCarNames: List<String>, tryCount: Int) {

    private val cars = racingCarNames.map(::Car)
    val movingDistanceHistory = Array(cars.size) {
        Array(tryCount) {
            cars[0].movingDistance
        }
    }

    fun play(tryCount: Int) {
        cars.forEachIndexed { index, car ->
            car.move(MOVING_CONDITION_RANGE.random())
            movingDistanceHistory[index][tryCount] = car.movingDistance
        }
    }

    companion object {
        private val MOVING_CONDITION_RANGE = 0..9
    }
}
