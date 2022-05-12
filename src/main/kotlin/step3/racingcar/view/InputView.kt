package step3.racingcar.view

import step3.racingcar.InputParser

object InputView {
    fun showNumberOfCarInitView(): Int {
        println("자동차 대수는 몇 대 인가요?")
        return InputParser.toInt(readln())
    }

    fun showTrialCountInitView(): Int {
        println("시도할 횟수는 몇 회 인가요?")
        return InputParser.toInt(readln())
    }
}
