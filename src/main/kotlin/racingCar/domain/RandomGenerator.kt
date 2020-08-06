package racingCar.domain

import kotlin.random.Random

object RandomGenerator {

    private const val RANDOM_LIMIT_NUM = 10

    fun getRandomNumber(): Int {
        return Random.nextInt(RANDOM_LIMIT_NUM)
    }
}
