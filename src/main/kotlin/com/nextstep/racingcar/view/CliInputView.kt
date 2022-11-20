package com.nextstep.racingcar.view

class CliInputView : InputView {
    override fun inputCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)")
        return readLine()!!.split(",").map { it.trim() }
    }

    override fun inputNumberOfRounds(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readLine()!!.toInt()
    }
}
