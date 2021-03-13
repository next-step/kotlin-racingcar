package racing.data

import racing.domain.Car
import racing.domain.CarName
import racing.domain.CarPosition

class CarState(
    val name: CarName,
    val position: CarPosition
) {
    companion object {
        fun from(car: Car): CarState {
            return CarState(car.name, car.position.copy())
        }
    }
}
