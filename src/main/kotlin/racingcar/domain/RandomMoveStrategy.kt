package racingcar.domain

class RandomMoveStrategy : MoveStrategy {

    override fun movable(): Boolean {
        return numberRange.random() >= MOVE_POINT
    }

    companion object {
        private val MOVE_POINT = Number.from(4)

        private val numberRange = (Number.from(1)..Number.from(9))
    }
}
