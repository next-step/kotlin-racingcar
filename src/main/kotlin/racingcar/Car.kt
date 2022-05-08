package racingcar

import racingcar.Location.Companion.BASE_LOCATION

class Car(
    var location: Location = BASE_LOCATION
) {
    fun move(movingStrategy: MovingStrategy) {
        if (movingStrategy.isMovable()) {
            location = location.forward()
        }
    }
}
