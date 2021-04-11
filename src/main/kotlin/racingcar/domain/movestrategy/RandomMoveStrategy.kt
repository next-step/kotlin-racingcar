package racingcar.domain.movestrategy

class RandomMoveStrategy : MoveStrategy {

    override fun movable(): Boolean {
        return NUMBER_RANGE.random() >= MOVE_POINT
    }

    companion object {
        private const val MOVE_POINT = 4
        private val NUMBER_RANGE = 0..9
    }
}
