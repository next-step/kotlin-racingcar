package racing.domain.strategy

object RandomNumberGenerator : Generator<Int> {
    private const val THRESHOLD = 10

    override fun generate(): Int = (0 until THRESHOLD).random()
}
