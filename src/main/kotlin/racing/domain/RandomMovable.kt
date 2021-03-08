package racing.domain

internal class RandomMovable(
    private val max: Int = DEFAULT_MAX,
    private val threshold: Int = DEFAULT_THRESHOLD
) : Movable {

    override fun isMovable(): Boolean {
        return (0..max).random() >= threshold
    }

    companion object {
        private const val DEFAULT_MAX = 9
        private const val DEFAULT_THRESHOLD = 4
    }
}
