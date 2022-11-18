package racingcar

import java.security.SecureRandom

object RacingCarUtil {
    private const val MAXIMUM_BOUND = 10
    private const val MINIMUM_BOUND = 4

    fun createRandomInt(): Int = SecureRandom.getInstanceStrong().nextInt(MAXIMUM_BOUND)

    fun checkMoveValue(value: Int): Boolean = value >= MINIMUM_BOUND
}
