package racingCar.domain

import kotlin.random.Random

object RandomNumberGenerator {
    private const val LIMIT_NUMBER = 10

    fun getRandomNumber(): Int = Random.nextInt(LIMIT_NUMBER)
}
