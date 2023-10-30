package racingcar.domain

class StubRandomMovingStrategy(
    private var condition: Int = 0,
): MovingStrategy {
    override fun isMovable(): Boolean {
        return condition >= MOVABLE_CONDITION
    }

    fun setCondition(condition: Int) {
        this.condition = condition
    }

    companion object {
        private const val MOVABLE_CONDITION = 4
    }
}