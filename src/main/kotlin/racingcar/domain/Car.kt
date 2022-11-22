package racingcar.domain

import racingcar.domain.strategy.MovingStrategy

data class Car(
    private val name: Name,
    private val strategy: MovingStrategy,
    private val distance: Distance
) {
    fun moveOrNot(): Car {
        return if (strategy.movable()) {
            this.copy(distance = distance.move())
        } else {
            this
        }
    }

    fun getDistance() = distance.getDistance()
    fun getName() = name.getName()
}
