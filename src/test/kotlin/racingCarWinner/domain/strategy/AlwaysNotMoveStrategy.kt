package racingCarWinner.domain

object AlwaysNotMoveStrategy : MoveStrategy {
    override fun isMovable(): Boolean {
        return false
    }
}
