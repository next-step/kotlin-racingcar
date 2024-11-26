package racingcar.util

import kotlin.random.Random

private const val RANDOM_MAX_NUMBER = 10

object RandomNumberGenerator : NumberGenerator {
    override fun generate(): Int {
        return Random.nextInt(RANDOM_MAX_NUMBER)
    }
}
