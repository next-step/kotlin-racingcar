package study.racingcar

class RandomMoveCarStrategy : MoveStrategy {
    override fun isMoveCar(location: Int): Boolean {
        return location >= MOVE_ALLOWABLE_VALUE
    }

    companion object {
        private const val MOVE_ALLOWABLE_VALUE = 4
    }
}
