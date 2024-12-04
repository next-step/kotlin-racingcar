package racing.model

object IntRangeEngineFactory {
    fun create(
        range: IntRange = IntRangeEngine.DEFAULT_RANDOM_RANGE,
        forwardLimit: Int = Car.DEFAULT_FORWARD_LIMIT,
    ): Engine {
        return IntRangeEngine(range, forwardLimit)
    }
}
