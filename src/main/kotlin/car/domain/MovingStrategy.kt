package car.domain

private const val MOVABLE_VALUE = 4
private const val START_VALUE = 0
private const val END_VALUE = 9

fun interface MovingStrategy {
    fun movable(): Boolean
}

class RandomMovingStrategy : MovingStrategy {
    override fun movable(): Boolean = RANDOM_VALUE_RANGE.random() >= MOVABLE_VALUE

    companion object {
        private val RANDOM_VALUE_RANGE = START_VALUE..END_VALUE
    }
}
