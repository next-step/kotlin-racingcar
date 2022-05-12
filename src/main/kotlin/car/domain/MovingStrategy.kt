package car.domain

private const val MOVABLE_VALUE = 4
private const val START_VALUE = 0
private const val END_VALUE = 10

fun interface MovingStrategy {
    fun movable(): Boolean
}

class RandomMovingStrategy : MovingStrategy {
    override fun movable(): Boolean = (START_VALUE until END_VALUE).random() >= MOVABLE_VALUE
}
