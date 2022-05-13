package racingcar.view

import racingcar.view.input.Input

class InputView(private val input: Input) {
    val carCount: Int by lazy { askCarCount() }
    val tryCount: Int by lazy { askTryCount() }

    private fun askCarCount(): Int {
        println("자동차 대수는 몇 대인가요?")
        return input.readCar()
    }

    private fun askTryCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return input.readTry()
    }
}
