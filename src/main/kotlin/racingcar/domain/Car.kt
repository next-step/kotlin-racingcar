package racingcar.domain

import racingcar.domain.strategy.MovingStrategy

data class Car(
    private val name: Name,
    private val strategy: MovingStrategy,
    private val distance: Distance
) {
    fun moveOrNot() {
        if (strategy.movable()) distance.move()
    }

    fun getDistance() = distance.getDistance()
    fun getName() = name.getName()
}
