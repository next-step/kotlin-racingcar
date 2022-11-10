package racingcar.domain

import racingcar.model.Position

class Car {

    private var distance: Position = Position()

    fun move(strategy: MovementStrategy) {
        if (strategy.isMovable()) {
            distance.plus()
        }
    }

    fun getDistance(): Int {
        return distance.toInt()
    }

    fun compareTo(other: Car): Int {
        return this.distance.compareTo(other.distance)
    }
}
