package car.racing.usecase

interface MovingStrategy {
    fun isMoveable(): Boolean
}

class NumberMovingStrategy(
    private val generator: Generator<Int>,
) : MovingStrategy {
    override fun isMoveable(): Boolean {
        val condition = generator.generate()
        return condition >= DATUM_POINT
    }

    companion object {
        private const val DATUM_POINT = 4
    }
}
