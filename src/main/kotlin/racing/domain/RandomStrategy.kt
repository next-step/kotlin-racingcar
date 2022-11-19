package racing.domain

class RandomStrategy : CarMoveStrategy {

    override fun isMovable(): Boolean {
        val random = (RANDOM_START_RANGE..RANDOM_END_RANGE).random()
        return MOVING_CONDITION <= random
    }

    companion object {
        private const val RANDOM_START_RANGE = 0
        private const val RANDOM_END_RANGE = 9
        private const val MOVING_CONDITION = 4
    }
}
