package racing.model

class FixedEngine(
    private val fixedValue: Int,
    override val forwardLimit: Int = Car.DEFAULT_FORWARD_LIMIT
): Engine {
    override fun canMoveForward(): Boolean {
        return fixedValue >= forwardLimit
    }
}
