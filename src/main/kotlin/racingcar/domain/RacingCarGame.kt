package racingcar.domain

class RacingCarGame(private val cars: Cars) {

    private fun shouldMove() = MOVE_CONDITION.random() >= MOVE_CONDITION_STANDARD

    fun play(attemptCount: Int, shouldMove: () -> Boolean = ::shouldMove): Cars {
        repeat(attemptCount) {
            cars.moveOrStopAll(shouldMove)
        }
        return cars
    }

    companion object {
        private const val MOVE_CONDITION_START = 0
        private const val MOVE_CONDITION_END = 9
        private const val MOVE_CONDITION_STANDARD = 4
        private val MOVE_CONDITION = (MOVE_CONDITION_START..MOVE_CONDITION_END)
    }
}
