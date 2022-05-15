package game.racingcar.strategy

class MustOneMoveStrategy : MoveStrategy {
    override fun move(current: Int): Int {
        return current + 1
    }
}
