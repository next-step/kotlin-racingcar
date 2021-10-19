package racingcar.domain.strategy

class MockRandomMovingStrategy(private val value: Int) : MovingStrategy {
    override fun movable(): Boolean = value >= MOVE_CONSTRAINTS

    companion object {
        private const val MAX_RANDOM_RANGE = 10
    }
}
