package racingCar.domain

import kotlin.random.Random

object RandomNumberGenerator {
    private const val LIMIT_NUMBER = 10

    fun generateRandomNumber(): Int = Random.nextInt(LIMIT_NUMBER)
}
