package racingcar

import racingcar.strategy.ForwardStrategy
import racingcar.strategy.MovingStrategy

class Car(
    private var distance: Int = 0,
    private val name: String = "car",
    private val strategy: MovingStrategy = ForwardStrategy(),
) {
    fun moveOrNot() {
        if (strategy.movable()) addDistance()
    }

    fun getDistance() = distance
    fun getName() = name

    private fun addDistance() = this.distance ++
}
