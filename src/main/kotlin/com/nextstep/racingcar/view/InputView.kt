package com.nextstep.racingcar.view

object InputView {
    fun inputNumberOfCar(): String? {
        println("자동차 대수는 몇 대인가요?")
        return readLine()
    }

    fun inputRound(): String? {
        println("시도할 횟수는 몇 회 인가요?")
        return readLine()
    }
}
