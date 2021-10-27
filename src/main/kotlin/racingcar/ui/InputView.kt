package racingcar.ui

import racingcar.constant.Message
import racingcar.util.Validation

object InputView {
    fun getCarCount(): Int {
        println(Message.INPUT_CAR_COUNT)
        return Validation.getCarCountToInt(readLine()!!)
    }

    fun retryGetCarCount(): Int {
        println(Message.INPUT_ONLY_NUMBER)
        return Validation.getCarCountToInt(readLine()!!)
    }

    fun getAttemptCount(): Int {
        println(Message.INPUT_ATTEMPT_COUNT)
        return Validation.getAttemptCountToInt(readLine()!!)
    }

    fun retryGetAttemptCount(): Int {
        println(Message.INPUT_ONLY_NUMBER)
        return Validation.getAttemptCountToInt(readLine()!!)
    }
}
