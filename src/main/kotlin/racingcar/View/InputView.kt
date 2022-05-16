package racingcar.View

import racingcar.IntParser

object InputView {
    fun getCarCount(): Int {
        println("자동차 대수는 몇 대인가요?")
        return IntParser.toInt(readln())
    }

    fun getTryCount(): Int {
        println("시도할 회수는 몇 회인가요?")
        return IntParser.toInt(readln())
    }
}
