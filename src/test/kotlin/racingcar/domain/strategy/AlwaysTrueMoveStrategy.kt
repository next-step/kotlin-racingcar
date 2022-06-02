package racingcar.domain.strategy

class AlwaysTrueMoveStrategy : MoveStrategy {
    override fun isMovable(): Boolean {
        return true
    }
}
