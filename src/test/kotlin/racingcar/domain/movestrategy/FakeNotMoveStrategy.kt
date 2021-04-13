package racingcar.domain.movestrategy

class FakeNotMoveStrategy : MoveStrategy {
    override fun movable() = false
}
