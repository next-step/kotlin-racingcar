package racingcar.common

import kotlin.random.Random

object RandomCommandGenerator {

    const val MIN_COMMAND = 0
    const val MAX_COMMAND = 9

    fun nextCommand(): Int {
        return Random.nextInt(MIN_COMMAND, MAX_COMMAND + 1)
    }
}
