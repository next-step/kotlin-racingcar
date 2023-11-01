package study.racing.strategy

class RandomMoveStrategyDouble(
    private val isMoving: Boolean
) : MoveStrategy {
    override fun isMoving(): Boolean {
        return isMoving
    }

    override fun isMoving(carIndex: Int, roundIndex: Int): Boolean {
        return isMoving
    }
}
