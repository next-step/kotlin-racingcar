package racing.domain.utils

import kotlin.random.Random

object RandomNumberGenerator {
    fun getRandomNumber() = Random.nextInt(RANDOM_NUMBER_START, RANDOM_NUMBER_END)

    private const val RANDOM_NUMBER_START = 0
    private const val RANDOM_NUMBER_END = 10
}
