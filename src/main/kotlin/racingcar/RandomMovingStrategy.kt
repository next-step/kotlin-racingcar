package racingcar

class RandomMovingStrategy : MovingStrategy {
    override fun movable(): Boolean {
        return (RANDOM_RANGE_MIN..RANDOM_RANGE_MAX).random() >= MIN_VALUE_TO_MOVE
    }

    companion object {
        const val MIN_VALUE_TO_MOVE: Int = 4
        const val RANDOM_RANGE_MIN: Int = 0
        const val RANDOM_RANGE_MAX: Int = 9
    }
}
