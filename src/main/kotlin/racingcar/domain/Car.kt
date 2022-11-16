package racingcar.domain

import racingcar.model.Position

class Car(private val carName: CarName, private var distance: Position = Position()) {

    fun move(strategy: MovementStrategy) {
        if (strategy.isMovable()) {
            distance = distance.plus()
        }
    }

    fun getDistance(): Int {
        return distance.getPosition()
    }

    fun getCarName(): String {
        return carName.text
    }

    fun compareTo(other: Car): Int {
        return this.distance.compareTo(other.distance)
    }
}
