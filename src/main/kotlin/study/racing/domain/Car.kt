package study.racing.domain

import study.racing.strategy.MoveStrategy
import study.racing.strategy.RandomMoveStrategy

class Car(
    private val strategy: MoveStrategy = RandomMoveStrategy(),
    name: CarName
) {

    var distance: Distance = Distance()
        private set
    var carName: CarName = name
        private set

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
