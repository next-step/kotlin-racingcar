package racing.domain

class RandomStrategy : CarMoveStrategy {

    override fun carMove(tryCount: Int): List<Int> = List(tryCount) {
        (RANDOM_START_RANGE..RANDOM_END_RANGE).random()
    }

    companion object {
        private const val RANDOM_START_RANGE = 0
        private const val RANDOM_END_RANGE = 9
    }
}
