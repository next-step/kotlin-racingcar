package step3.racingcar.utils

object RandomNumberGenerator {
    private const val RANGE_START = 1
    private const val RANGE_END = 9

    fun generate(): Int = (RANGE_START..RANGE_END).random()
}
