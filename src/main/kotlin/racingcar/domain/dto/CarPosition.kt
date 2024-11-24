package racingcar.domain.dto

import racingcar.domain.Car

data class CarPosition(
    val name: String,
    val position: Int,
) {
    companion object {
        fun from(car: Car): CarPosition {
            return CarPosition(car.name, car.position)
        }
    }
}
