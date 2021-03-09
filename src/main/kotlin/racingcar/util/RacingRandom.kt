package racingcar.util

import racingcar.util.Message.Companion.MAX_CONDITION
import racingcar.util.Message.Companion.MIN_CONDITION
import racingcar.util.Message.Companion.MIN_CONDITION_FOR_GOING
import kotlin.random.Random

object RacingRandom {
    fun canGo() = Random.nextInt(MIN_CONDITION, MAX_CONDITION) > MIN_CONDITION_FOR_GOING
}
