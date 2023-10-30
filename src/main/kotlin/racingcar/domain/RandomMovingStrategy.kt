package racingcar.domain

class RandomMovingStrategy: MovingStrategy {
    override fun isMovable(): Boolean {
        return generateRandomNumber() >= MOVABLE_CONDITION
    }

    fun generateRandomNumber(): Int {
        return (Math.random() * MAX_CONDITION).toInt()
    }

    companion object {
        const val MOVABLE_CONDITION = 4
        const val MAX_CONDITION = 10
    }
}