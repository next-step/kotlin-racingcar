package racing

object Distance {
    private val DISTANCE_RANGE = (0..10)
    private const val STANDARD_DISTANCE = 4

    fun getRandom() = DISTANCE_RANGE.random()

    fun get(): Int {
        val randomDistance = getRandom()

        return when {
            randomDistance >= STANDARD_DISTANCE -> randomDistance
            else -> 0
        }
    }
}
