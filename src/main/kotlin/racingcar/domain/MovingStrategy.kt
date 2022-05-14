package racingcar.domain

fun interface MovingStrategy {
    fun isMovable(): Boolean
}

class DefaultStrategy(
    private val numberGenerator: NumberGenerator = RandomNumberGenerator
) : MovingStrategy {

    override fun isMovable(): Boolean {
        val number = numberGenerator.generate(MOVING_CONDITION_MIN, MOVING_CONDITION_MAX)
        return number >= MOVABLE_MIN_CONDITION
    }

    companion object {
        private const val MOVING_CONDITION_MIN = 0
        private const val MOVING_CONDITION_MAX = 9
        private const val MOVABLE_MIN_CONDITION = 4
    }
}
