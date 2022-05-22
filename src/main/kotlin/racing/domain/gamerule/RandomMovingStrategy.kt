package racing.domain.gamerule

class RandomMovingStrategy : MovingStrategy {
    private val MOVING_RANGE = 1..9

    override fun isMovable(): Boolean {
        return MOVING_RANGE.random() > LIMIT_NUMBER
    }

    companion object {
        private const val LIMIT_NUMBER = 4
    }
}
