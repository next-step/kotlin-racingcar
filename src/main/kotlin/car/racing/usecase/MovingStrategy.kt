package car.racing.usecase

interface MovingStrategy<T> {
    fun isMoveable(condition: T): Boolean
}

class NumberMovingStrategy : MovingStrategy<Int> {
    override fun isMoveable(condition: Int): Boolean {
        return condition >= DATUM_POINT
    }

    companion object {
        private const val DATUM_POINT = 4
    }
}
