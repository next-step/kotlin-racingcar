package racingcar.util

import kotlin.random.Random

class RandomUtil {
    companion object {
        fun generateRandomNumber(includeFrom: Int, includeUntil: Int): Int {
            return Random.nextInt(includeFrom, includeUntil + 1)
        }
    }
}
