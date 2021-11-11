package racingcar.view

import racingcar.constant.Message

object InputView {
    fun getCarsName(): String {
        println(Message.INPUT_CAR_NAME)
        return readLine()!!
    }

    fun getAttemptCount(): String {
        println(Message.INPUT_ATTEMPT_COUNT)
        return readLine()!!
    }
}
