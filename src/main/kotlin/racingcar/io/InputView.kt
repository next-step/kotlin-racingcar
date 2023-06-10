package racingcar.io

import racingcar.domain.Input

class InputView {
    fun getInput(): Input {
        println("자동차 대수는 몇 대인가요?")
        val carCount = readlnOrNull()!!.toInt()

        println("시도할 횟수는 몇 회인가요?")
        val rounds = readlnOrNull()!!.toInt()

        return Input(carCount, rounds)
    }
}
