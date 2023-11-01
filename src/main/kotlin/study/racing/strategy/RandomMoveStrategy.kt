package study.racing.strategy

class RandomMoveStrategy : MoveStrategy {

    override fun isMoving(): Boolean {
        return (0..9).random() >= 4
    }
}
