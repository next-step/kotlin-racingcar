package racingcar.view

import racingcar.view.input.Input

class InputView(private val input: Input) {
    var carCount = 0
        private set
    var tryCount = 0
        private set

    fun start() {
        println("자동차 대수는 몇 대인가요?")
        this.carCount = input.readCar()

        println("시도할 횟수는 몇 회인가요?")
        this.tryCount = input.readTry()
    }
}