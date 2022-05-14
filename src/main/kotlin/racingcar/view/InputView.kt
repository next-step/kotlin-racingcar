package racingcar.view

import racingcar.InputParser

object InputView {
    private const val CAR_NAME_DILIMITER = ","
    fun getNumberOfCarByConsole(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n")
        return readln().split(CAR_NAME_DILIMITER)
    }

    fun getTrialCountByConsole(): Int {
        println("시도할 횟수는 몇 회 인가요?")
        return InputParser.toInt(readln())
    }
}
