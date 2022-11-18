package racingcar

import java.security.SecureRandom

object RacingCarUtil {
    private const val MAXIMUM_BOUND = 10

    fun createRandomInt(): Int = SecureRandom.getInstanceStrong().nextInt(MAXIMUM_BOUND)
}
