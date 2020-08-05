package racingcar

import racingcar.strategy.Strategy

class Car(val position: MutableList<Int>, private val strategy: Strategy) {
    fun forward() = position.add(position.last() + 1)
    fun wait() = position.add(position.last())

    fun run() {
        when (strategy.move(strategy.generateNumber())) {
            true -> forward()
            false -> wait()
        }
    }
}
