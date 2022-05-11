package step3.racingcar.car.strategy

class AlwaysMoveStrategy : MoveStrategy {
    override fun isMovable(): Boolean {
        return true
    }
}
