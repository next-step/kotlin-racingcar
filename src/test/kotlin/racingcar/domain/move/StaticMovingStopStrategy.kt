package racingcar.domain.move

class StaticMovingStopStrategy : Movable {
    override fun move(): Boolean {
        return false
    }
}
