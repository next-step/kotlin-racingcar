package racinggame.domain

import kotlin.random.Random
import kotlin.random.nextInt

object RandomNumberGenerator {
    private const val START_RANGE = 0
    private const val END_RANGE = 9

    fun create(): Int {
        return Random.nextInt(START_RANGE..END_RANGE)
    }
}
