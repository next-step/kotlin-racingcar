package racingcar.domain.strategy

class AlwaysFalseMoveStrategy : MoveStrategy {
    override fun isMovable(): Boolean {
        return false
    }
}
