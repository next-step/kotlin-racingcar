package racing.util

object RandomGenerator {
    private const val RANDOM_VALUE_FROM = 0
    private const val RANDOM_VALUE_UNTIL = 9

    fun getIntRangeRandom(): Int =
        (RANDOM_VALUE_FROM..RANDOM_VALUE_UNTIL).random()
}