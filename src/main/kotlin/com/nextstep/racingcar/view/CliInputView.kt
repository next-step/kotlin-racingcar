package com.nextstep.racingcar.view

class CliInputView : InputView {

    override fun inputNumberOfCars(): Int {
        println("자동차 대수는 몇 대인가요?")
        return readLine()!!.toInt()
    }

    override fun inputNumberOfRounds(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readLine()!!.toInt()
    }
}
