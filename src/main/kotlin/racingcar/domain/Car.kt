package racingcar.domain

import racingcar.domain.strategy.MovingStrategy

class Car(
    private val name: Name,
    private val strategy: MovingStrategy,
    private var distance: Distance
) {
    fun moveOrNot() {
        if (strategy.movable()) distance.move()
    }

    fun getDistance() = distance.getDistance()
    fun getName() = name.getName()
}
