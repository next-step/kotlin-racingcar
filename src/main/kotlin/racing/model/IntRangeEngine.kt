package racing.model

class IntRangeEngine(
    private val range: IntRange = DEFAULT_RANDOM_RANGE,
    override val forwardLimit: Int = Car.DEFAULT_FORWARD_LIMIT
): Engine {
    override fun canMoveForward(): Boolean {
        val number = range.random()
        return number >= forwardLimit
    }

    companion object {
        val DEFAULT_RANDOM_RANGE = 0..9
    }
}
