package racingcar.domain

class DummyMoveStrategy : MoveStrategy {
    override fun isMoveable(): Boolean {
        return false
    }
}
