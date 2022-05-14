package racingcar

import racingcar.view.input.Input

class StubInput(private val carCount: Int, private val tryCount: Int) : Input {
    override fun readCar(): Int {
        return this.carCount
    }

    override fun readTry(): Int {
        return this.tryCount
    }
}
