package racingcar.domain.strategy

data class TestMovingStrategy(private val input: Int) : MovingStrategy {
    override fun isMovable() = input >= MOVING_CRITERIA
}
