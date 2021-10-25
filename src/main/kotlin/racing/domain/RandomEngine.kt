package racing.domain

object RandomEngine : Engine {

    private const val MOVING_THRESHOLD = 4

    private val movingRange = (0..9)

    override fun canMove(): Boolean {
        return movingRange.random() >= MOVING_THRESHOLD
    }
}
