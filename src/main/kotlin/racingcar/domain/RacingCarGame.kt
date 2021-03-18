package racingcar.domain

class RacingCarGame(private val carCount: Int) {

    private fun shouldMove() =
        (MOVE_CONDITION_START..MOVE_CONDITION_END).random() >= MOVE_CONDITION_STANDARD

    fun play(attemptCount: Int, shouldMove: () -> Boolean = ::shouldMove): List<Car> {
        val cars = List(carCount) { Car() }
        repeat(attemptCount) {
            cars.forEach { car -> car.moveOrStop(shouldMove()) }
        }
        return cars
    }

    companion object {
        private const val MOVE_CONDITION_START = 0
        private const val MOVE_CONDITION_END = 9
        private const val MOVE_CONDITION_STANDARD = 9
    }
}
