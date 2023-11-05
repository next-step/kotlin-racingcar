package racing_car.domain

class RandomAboveThresholdMoveStrategy : MoveStrategy {

    override fun canMove(): Boolean {
        val randomNumber = (RANDOM_NUMBER_MIN..RANDOM_NUMBER_MAX).random()
        return randomNumber >= MOVE_THRESHOLD
    }

    companion object {
        private const val MOVE_THRESHOLD = 4
        private const val RANDOM_NUMBER_MIN = 0
        private const val RANDOM_NUMBER_MAX = 9
    }
}
