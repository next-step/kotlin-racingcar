package racingCar

import kotlin.random.Random

object RandomGenerator {
    fun getRandomNumber(): Int {
        return Random.nextInt(RANDOM_LIMIT_NUM)
    }
}
