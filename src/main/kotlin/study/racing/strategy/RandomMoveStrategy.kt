package study.racing.strategy

class RandomMoveStrategy : MoveStrategy {

    override fun isMoving(): Boolean {
        return (0..9).random() >= 4
    }

    override fun isMoving(
        carIndex: Int,
        roundIndex: Int,
    ): Boolean {
        return SoloWinnerMoveStrategy().isMoving(carIndex, roundIndex)
    }
}
