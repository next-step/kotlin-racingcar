package racingcar

import kotlin.random.Random

object RandomCountGenerator {
    fun generateCount() = Random(System.currentTimeMillis()).nextInt(0, 10)
}
