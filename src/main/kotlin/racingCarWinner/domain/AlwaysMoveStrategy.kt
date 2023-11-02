package racingCarWinner.domain

object AlwaysMoveStrategy : MoveStrategy {
    override fun isMovable(): Boolean {
        return true
    }
}
