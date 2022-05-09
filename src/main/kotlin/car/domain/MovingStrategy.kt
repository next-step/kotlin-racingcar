package car.domain

fun interface MovingStrategy {
    fun movable(): Boolean
}

class RandomMovingStrategy : MovingStrategy {
    override fun movable(): Boolean {
        return (0..9).random() >= 4
    }
}
