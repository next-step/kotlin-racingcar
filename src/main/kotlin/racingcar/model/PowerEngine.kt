package racingcar.model

import racingcar.util.Message
import java.util.Random

class PowerEngine {
    fun canGo(): Boolean {
        val random = Random()
        return random.nextInt(Message.MAX_CONDITION) > Message.MIN_CONDITION_FOR_GOING
    }
}
