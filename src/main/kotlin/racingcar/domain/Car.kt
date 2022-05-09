package racingcar.domain

import racingcar.domain.Location.Companion.BASE_LOCATION

class Car(
    private var _location: Location = BASE_LOCATION
) {
    val location: Location
        get() = _location

    fun move(movingStrategy: MovingStrategy) {
        if (movingStrategy.isMovable()) {
            _location = _location.forward()
        }
    }
}
