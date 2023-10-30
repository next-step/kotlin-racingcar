package study.racing.domain

import study.racing.strategy.MoveStrategy
import study.racing.strategy.RandomMoveStrategy

class Car(
    private val strategy: MoveStrategy = RandomMoveStrategy(),
    name: CarName
) {

    val distance: Distance = Distance()
    val carName: CarName = name

    fun getCarDistance(): Int {
        return this.distance.moveDistance
    }

    fun tryMoveTheCar() {
        if (strategy.isMoving()) {
            this.distance.moveForward()
        }
    }

    fun getCarName(): String {
        return this.carName.name
    }
}
