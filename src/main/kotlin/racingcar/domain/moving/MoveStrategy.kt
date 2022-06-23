package racingcar.domain.moving

interface MoveStrategy {
    fun isMovable(): Boolean
}

class RandomBasedMoveStrategy : MoveStrategy {
    override fun isMovable(): Boolean =
        (RANDOM_NUMBER_RANGE).random() >= MOVABLE_MINIMUM_NUMBER

    companion object {
        private const val MINIMUM_NUMBER = 0
        private const val MAXIMUM_NUMBER = 9
        private val RANDOM_NUMBER_RANGE = MINIMUM_NUMBER..MAXIMUM_NUMBER
        private const val MOVABLE_MINIMUM_NUMBER = 4
    }
}
