package racingcar.domain

class UnmoveableMoveStrategy : MoveStrategy {
    override fun isMoveable(): Boolean {
        return false
    }
}
