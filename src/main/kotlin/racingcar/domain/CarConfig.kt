package racingcar.domain

import kotlin.random.Random

object CarConfig {
    const val MOVE_PERCENTAGE = 4
    const val BASE_PERCENTAGE = 10

    fun randomNumberGenerator(number: Int): List<Int> = MutableList(number) { Random.nextInt(BASE_PERCENTAGE) }
}
