package racing.data

import racing.domain.Car
import racing.domain.CarName
import racing.domain.CarPosition

data class CarState(
    val name: CarName,
    val position: CarPosition
) {
    companion object {
        fun of(car: Car): CarState {
            return CarState(car.name.copy(), car.position.copy())
        }
    }
}
