package racingcar

import racingcar.strategy.ForwardStrategy
import racingcar.strategy.MovingStrategy

class Car(
    private var distance: Int = 0,
    private val name: String,
    private val strategy: MovingStrategy = ForwardStrategy(),
) {
    fun move() {
        if (strategy.move()) addDistance()
    }

    fun getDistance() = distance
    fun getName() = name

    private fun addDistance() = this.distance ++
}
