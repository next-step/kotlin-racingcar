package racingcar.util

import java.util.Random

object RacingRandom : Random() {
    fun canGo() = nextInt(Message.MAX_CONDITION) > Message.MIN_CONDITION_FOR_GOING
}
