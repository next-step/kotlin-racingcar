package game.racingcar.strategy

class RandomMoveStrategy : MoveStrategy {
    override fun move(current: Int): Int {
        return if (TOTAL_RANGE.random() in MOVABLE_RANGE) current + MOVING_UNIT else current
    }

    companion object {
        const val MOVING_UNIT = 1
        private val TOTAL_RANGE = 0..9
        private val MOVABLE_RANGE = 4..9
    }
}
