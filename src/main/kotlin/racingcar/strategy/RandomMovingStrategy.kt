package racingcar.strategy

class RandomMovingStrategy : MovingStrategy {

    override val isMovable: Boolean
        get() = (BOUND_MIN..BOUND_MAX).random() >= MOVABLE_BASE_VALUE

    companion object {
        private const val BOUND_MIN = 0
        private const val BOUND_MAX = 9
        private const val MOVABLE_BASE_VALUE = 4
    }
}
