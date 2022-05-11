package car.domain

fun interface MovingStrategy {
    fun movable(): Boolean
}

private const val MOVABLE_VALUE = 4
private const val START_VALUE = 0
private const val END_VALUE = 10

class RandomMovingStrategy : MovingStrategy {
    override fun movable(): Boolean {
        return (START_VALUE..END_VALUE).random() >= MOVABLE_VALUE
    }
}
