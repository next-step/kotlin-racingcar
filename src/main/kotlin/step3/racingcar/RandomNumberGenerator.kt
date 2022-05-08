package step3.racingcar

object RandomNumberGenerator {
    private val NUMBER_RANGE = 1..9

    fun generate(): Int {
        return NUMBER_RANGE.random()
    }
}
