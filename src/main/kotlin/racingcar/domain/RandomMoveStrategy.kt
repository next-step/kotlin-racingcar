package racingcar.domain

class RandomMoveStrategy : MoveStrategy {

    override fun movable(): Boolean {
        return Number(numberRange.random()) >= MOVE_POINT
    }

    companion object {
        private val MOVE_POINT = Number(4)
        private val numberRange = (Number.MINIMUM_VALUE..Number.MAXIMUM_VALUE)
    }
}
