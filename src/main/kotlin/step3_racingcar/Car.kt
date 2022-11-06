package step3_racingcar

import step3_racingcar.strategy.ForwardStrategy

class Car(
    private var distance: Int = 0,
    private val strategy: ForwardStrategy
) {
    fun move() {
        if (strategy.move()) addDistance()
    }

    private fun addDistance() = this.distance ++
}
