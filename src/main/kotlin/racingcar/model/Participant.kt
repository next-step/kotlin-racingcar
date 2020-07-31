package racingcar.model

class Participant(racingCarNames: List<String>) {

    private val cars = racingCarNames.map(::Car)

    fun play() {
        cars.forEach {
            it.move(MOVING_CONDITION_RANGE.random())
        }
    }

    fun getDistanceOfEachCar(): List<Int> = cars.map { it.movingDistance }

    companion object {
        private val MOVING_CONDITION_RANGE = 0..9
    }
}
