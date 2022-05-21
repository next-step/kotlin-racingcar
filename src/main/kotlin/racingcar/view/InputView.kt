package racingcar.view

import IntParser

object InputView {

    fun getPlayerName(): List<String> {
        println(MESSAGE_DRIVER_NAME_MESSAGE)
        return readln().split(',')
    }

    fun getTryCount(): Int {
        println(MESSAGE_TRY_COUNT_MESSAGE)
        return IntParser.toInt(readln())
    }

    private const val MESSAGE_DRIVER_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    private const val MESSAGE_TRY_COUNT_MESSAGE = "시도할 회수는 몇 회인가요?"
}
