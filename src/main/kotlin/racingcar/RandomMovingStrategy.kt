package racingcar

class RandomMovingStrategy : MovingStrategy {
    override fun isMovable(): Boolean {
        return generateRandomNumber() >= BASELINE_VALUE
    }

    private fun generateRandomNumber() = (MIN_RANGE..MAX_RANGE).random()

    companion object {
        private const val MIN_RANGE = 0
        private const val MAX_RANGE = 9
        private const val BASELINE_VALUE = 4
    }
}
