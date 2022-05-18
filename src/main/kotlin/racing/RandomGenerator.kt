package racing

object RandomGenerator {
    private const val MIN_BOUND = 0
    private const val MAX_BOUND = 9

    fun generate(): Int = (MIN_BOUND..MAX_BOUND).random()
}
