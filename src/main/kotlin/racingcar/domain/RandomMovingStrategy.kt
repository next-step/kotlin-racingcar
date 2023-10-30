package racingcar.domain

class RandomMovingStrategy: MovingStrategy {
    override fun isMovable(): Boolean {
        return generateRandomNumber() >= MOVABLE_CONDITION
    }

    fun generateRandomNumber(): Int {
        return (Math.random() * MAX_CONDITION).toInt()
    }

    companion object {
        private const val MOVABLE_CONDITION = 4
        private const val MAX_CONDITION = 10
    }
}