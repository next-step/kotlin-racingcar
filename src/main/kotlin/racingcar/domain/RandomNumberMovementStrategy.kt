package racingcar.domain

class RandomNumberMovementStrategy : MovementStrategy {

    companion object {
        private const val MOVING_MIN_NUMBER = 0
        private const val MOVING_MAX_NUMBER = 9
        private const val MOVING_BOUNDED_NUMBER = 4
        private val range = (MOVING_MIN_NUMBER..MOVING_MAX_NUMBER)
    }

    override fun isMovable(): Boolean {
        return MOVING_BOUNDED_NUMBER <= range.random()
    }
}
