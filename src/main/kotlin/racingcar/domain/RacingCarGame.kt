package racingcar.domain

class RacingCarGame(private val carCount: Int) {

    private fun shouldMove() = (0..9).random() >= 4

    fun play(attemptCount: Int, shouldMove: Boolean = shouldMove()): List<Car> {
        val cars = List(carCount) { Car() }
        for (i in 0 until attemptCount) {
            cars.forEach { it.moveOrStop(shouldMove) }
        }
        return cars
    }
}
