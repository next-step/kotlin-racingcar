package racingcar.domain

import racingcar.domain.Location.Companion.BASE_LOCATION

class Car(
    val carName: CarName = CarName.DEFAULT_NAME,
    location: Location = BASE_LOCATION
) {
    private var _location = location
    val location get() = _location

    fun move(movingStrategy: MovingStrategy) {
        if (movingStrategy.isMovable()) {
            _location = _location.forward()
        }
    }
}
