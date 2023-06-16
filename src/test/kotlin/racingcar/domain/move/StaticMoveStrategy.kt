package racingcar.domain.move

class StaticMoveStrategy : Movable {
    override fun move(): Boolean {
        return true
    }
}
