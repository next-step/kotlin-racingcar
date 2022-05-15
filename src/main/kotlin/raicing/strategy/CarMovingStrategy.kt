package raicing.strategy

object CarMovingStrategy : MovingStrategy {
    private const val MIN_RANDOM_BOUND = 1
    private const val MAX_RANDOM_BOUND = 10
    private const val BASE_NUM = 4

    override fun canMoveForward(): Boolean =
        getRandomMoveNumber() >= BASE_NUM

    private fun getRandomMoveNumber(): Int =
        (MIN_RANDOM_BOUND..MAX_RANDOM_BOUND).random()
}
