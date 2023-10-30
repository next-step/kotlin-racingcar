package racingcar.domain

class StubRandomMovingStrategy(
    private var condition: Int = 0,
): MovingStrategy {
    override fun isMovable(): Boolean {
        return condition >= RandomMovingStrategy.MOVABLE_CONDITION
    }

    fun setCondition(condition: Int) {
        this.condition = condition
    }
}