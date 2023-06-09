package step3.domain.strategy

object RandomMoveStrategy : MoveStrategy {
    private const val MIN_RANDOM_NUMBER = 0
    private const val MAX_RANDOM_NUMBER = 9
    private const val THRESHOLD = 4

    override fun movable(): Boolean {
        val random = (MIN_RANDOM_NUMBER..MAX_RANDOM_NUMBER).random()
        return random >= THRESHOLD
    }
}
