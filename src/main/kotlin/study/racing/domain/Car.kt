package study.racing.domain

import study.racing.strategy.MoveStrategy
import study.racing.strategy.RandomMoveStrategy

class Car(
    private val strategy: MoveStrategy = RandomMoveStrategy()
) {

    private val distance: Distance = Distance()

    fun getCarDistance(): Int {
        return this.distance.moveDistance
    }

    fun tryMoveTheCar() {
        if (strategy.isMoving()) {
            this.distance.moveForward()
        }
    }
}
