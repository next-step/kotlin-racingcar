package racingcar.utils

import java.util.*

object RandomGenerator {
    fun getRandomIntNumber(threshold: Int): Int {
        return Random().nextInt(threshold)
    }
}