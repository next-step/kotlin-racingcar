package game.racingcar.strategy

class MustOneMoveStrategy : MoveStrategy {
    override fun move(current: Int) = current + 1
}
