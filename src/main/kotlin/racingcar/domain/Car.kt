package racingcar.domain

import racingcar.etc.NonNegative

class Car {

    private var distance: NonNegative = NonNegative()

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
