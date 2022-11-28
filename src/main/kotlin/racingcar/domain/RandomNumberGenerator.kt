package racingcar.domain

object RandomNumberGenerator {
    private const val RANDOMIZE_MIN_NUMBER = 0
    private const val RANDOMIZE_MAX_NUMBER = 9

    fun getRandomNumber(): Int = (RANDOMIZE_MIN_NUMBER..RANDOMIZE_MAX_NUMBER).random()
}
