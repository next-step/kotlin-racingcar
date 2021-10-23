package racingcar.ui

import racingcar.constant.Message
import racingcar.util.CarValidation

object InputView {
    fun getCarCount(): Int {
        println(Message.INPUT_CAR_COUNT)
        return CarValidation.getCarCountToInt(readLine()!!)
    }

    fun retryGetCarCount(): Int {
        println(Message.INPUT_ONLY_NUMBER)
        return CarValidation.getCarCountToInt(readLine()!!)
    }

    fun getAttemptCount(): Int {
        println(Message.INPUT_ATTEMPT_COUNT)
        return CarValidation.getAttemptCountToInt(readLine()!!)
    }

    fun retryGetAttemptCount(): Int {
        println(Message.INPUT_ONLY_NUMBER)
        return CarValidation.getAttemptCountToInt(readLine()!!)
    }
}
