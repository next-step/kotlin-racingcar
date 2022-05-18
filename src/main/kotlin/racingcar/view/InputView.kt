package racingcar.view

import IntParser

object InputView {
    fun getCarCount(): Int {
        println(MESSAGE_CAR_COUNT_MESSAGE)
        return IntParser.toInt(readln())
    }

    fun getTryCount(): Int {
        println(MESSAGE_TRY_COUNT_MESSAGE)
        return IntParser.toInt(readln())
    }

    private const val MESSAGE_CAR_COUNT_MESSAGE = "자동차 대수는 몇 대인가요?"
    private const val MESSAGE_TRY_COUNT_MESSAGE = "시도할 회수는 몇 회인가요?"
}
