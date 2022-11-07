package racingcar

import racingcar.strategy.ForwardStrategy

class Car(
    var distance: Int = 0,
    private val strategy: ForwardStrategy
) {
    fun move(): Car {
        if (strategy.move()) addDistance()
        return this
    }

    private fun addDistance() = this.distance ++
}
