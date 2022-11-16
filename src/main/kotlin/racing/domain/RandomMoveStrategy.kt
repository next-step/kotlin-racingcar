package racing.domain

class RandomMoveStrategy : MoveStrategy {

    override fun getMoveDistance(): Int {
        val randomNumber = (RANDOM_NUMBER_MIN..RANDOM_NUMBER_MAX).random()
        if (randomNumber <= MOVE_THRESHOLD)
            return 1
        return 0
    }

    companion object {
        private const val MOVE_THRESHOLD = 4
        private const val RANDOM_NUMBER_MIN = 0
        private const val RANDOM_NUMBER_MAX = 9
    }
}
