package racingcar.domain

import racingcar.etc.NonNegative

class Car(val carName: CarName, var distance: NonNegative = NonNegative()) {

    fun move(strategy: MovementStrategy) {
        if (strategy.isMovable()) {
            distance.plus()
        }
    }

    fun compareTo(other: Car): Int {
        return this.distance.compareTo(other.distance)
    }
}
