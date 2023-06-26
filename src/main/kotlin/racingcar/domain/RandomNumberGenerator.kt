package racingcar.domain

object RandomNumberGenerator {

    private const val MIN_NUMBER = 0
    private const val MAX_NUMBER = 9

    fun generate(): Int {
        return (MIN_NUMBER..MAX_NUMBER).random()
    }
}
