package racing.model

object CarMovingStrategy : MovingStrategy {
    private const val MOVABLE_MIN_NUMBER = 4

    override fun isMovable(): Boolean {
        val number = RandomNumberGenerator.generateRandomNumber()
        return number >= MOVABLE_MIN_NUMBER
    }
}
