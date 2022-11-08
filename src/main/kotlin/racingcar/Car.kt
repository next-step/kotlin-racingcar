package racingcar

import racingcar.strategy.ForwardStrategy
import racingcar.strategy.MovingStrategy

class Car(
    private var distance: Int = 0,
    private val strategy: MovingStrategy = ForwardStrategy()
) {
    fun move() {
        if (strategy.move()) addDistance()
    }

    fun getDistance() = distance

    private fun addDistance() = this.distance ++
}
