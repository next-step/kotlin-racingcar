package racingcar.model

data class Car(
    val name: CarName,
    val position: Int = DEFAULT_POSITION,
    private val movingStrategy: MovingStrategy
) {

    fun moveForward(): Car {
        return when (movingStrategy.forwardMovable()) {
            true -> forward()
            false -> stop()
        }
    }

    private fun forward() = copy(position = position + 1)

    private fun stop() = copy()

    // movingStrategy 제외
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Car

        if (name != other.name) return false
        if (position != other.position) return false

        return true
    }

    // movingStrategy 제외
    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + position
        return result
    }
    companion object {
        internal const val DEFAULT_POSITION = 0
        internal const val MAX_BOUND = 10
    }
}
