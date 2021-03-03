package racingcar.util

import kotlin.random.Random

object RacingRandom {
    fun canGo() = Random(Message.MAX_CONDITION).nextInt() > Message.MIN_CONDITION_FOR_GOING
}
