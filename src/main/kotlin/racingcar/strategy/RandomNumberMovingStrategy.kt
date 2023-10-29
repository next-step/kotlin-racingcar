package racingcar.strategy

class RandomNumberMovingStrategy : MovingStrategy {
    override fun canMove(): Boolean = (RANDOM_LOWER_BOUND..RANDOM_UPPER_BOUND).random() >= BOUND_CONDITION

    companion object {
        private const val RANDOM_LOWER_BOUND = 0
        private const val RANDOM_UPPER_BOUND = 10
        private const val BOUND_CONDITION = 4
    }
}
